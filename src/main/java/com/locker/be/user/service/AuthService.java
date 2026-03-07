package com.locker.be.user.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.locker.be.user.dto.AuthDto;
import com.locker.be.user.mapper.AuthMapper;
import com.locker.be.user.util.JwtUserPrincipal;
import com.locker.be.user.util.JwtUtil;
import com.locker.be.user.util.NicknameGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper authMapper;
    private final JwtUtil jwtUtil;

    @Value("${google.client-id}")
    private String googleClientId;

    public AuthDto.GoogleLoginRes googleLogin(AuthDto.GoogleLoginReq req) {
        GoogleIdToken.Payload payload = verifyGoogleIdToken(req.getIdToken());

        String providerType = "GOOGLE";
        String providerKey = payload.getSubject();
        String nickname = NicknameGenerator.generateWithNumber();

        AuthDto.GoogleUserUpsertParam param = new AuthDto.GoogleUserUpsertParam();
        param.setProviderType(providerType);
        param.setProviderKey(providerKey);
        param.setNickname(nickname);
        System.out.println("=== GOOGLE LOGIN START ===");
        System.out.println("providerType = " + providerType);
        System.out.println("providerKey = " + providerKey);
        System.out.println("nickname = " + nickname);

        AuthDto.UserInfo userInfo = authMapper.loginOrRegisterGoogle(param);

        System.out.println("=== USER INFO ===");
        System.out.println("userInfo = " + userInfo);
        String accessToken = null;

        if ("SUCCESS".equals(userInfo.getResultCode())) {
            accessToken = jwtUtil.createAccessToken(
                    userInfo.getUserId(),
                    userInfo.getNickname()
            );
        }

        return new AuthDto.GoogleLoginRes(
                userInfo.getUserId(),
                userInfo.getNickname(),
                userInfo.getResultCode(),
                userInfo.getResultMessage(),
                accessToken
        );
    }

    public AuthDto.MeRes me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof JwtUserPrincipal principal)) {
            throw new RuntimeException("인증 정보가 없습니다.");
        }

        AuthDto.MeRes meRes = authMapper.selectMe(principal.getUserId());

        if (meRes == null) {
            throw new RuntimeException("사용자 정보를 찾을 수 없습니다.");
        }

        return meRes;
    }

    private GoogleIdToken.Payload verifyGoogleIdToken(String idTokenString) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(),
                    GsonFactory.getDefaultInstance()
            )
                    .setAudience(Collections.singletonList(googleClientId))
                    .build();

            GoogleIdToken idToken = verifier.verify(idTokenString);

            if (idToken == null) {
                throw new RuntimeException("유효하지 않은 구글 id_token 입니다.");
            }

            return idToken.getPayload();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("구글 id_token 검증 중 오류가 발생했습니다.", e);
        }
    }
}