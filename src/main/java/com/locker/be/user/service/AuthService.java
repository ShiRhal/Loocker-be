package com.locker.be.user.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.locker.be.user.dto.AuthDto;
import com.locker.be.user.util.NicknameGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class AuthService {

    @Value("${google.client-id}")
    private String googleClientId;

    public AuthDto.GoogleLoginRes googleLogin(AuthDto.GoogleLoginReq req) {
        GoogleIdToken.Payload payload = verifyGoogleIdToken(req.getIdToken());

        String providerType = "GOOGLE";
        String providerKey = payload.getSubject();
        String nickname = NicknameGenerator.generateWithNumber();

        System.out.println("=== GOOGLE LOGIN VERIFY SUCCESS ===");
        System.out.println("providerType = " + providerType);
        System.out.println("providerKey  = " + providerKey);
        System.out.println("nickname     = " + nickname);

        return new AuthDto.GoogleLoginRes(
                null,
                nickname,
                providerType,
                providerKey
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