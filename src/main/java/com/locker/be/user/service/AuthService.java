package com.locker.be.user.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.locker.be.user.dto.AuthDto;
import com.locker.be.user.mapper.AuthMapper;
import com.locker.be.user.util.NicknameGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper authMapper;

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

        AuthDto.UserInfo userInfo = authMapper.loginOrRegisterGoogle(param);

        return new AuthDto.GoogleLoginRes(
                userInfo.getUserId(),
                userInfo.getNickname(),
                userInfo.getResultCode(),
                userInfo.getResultMessage()
        );
    }

    public AuthDto.MeRes me() {
        return null;
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