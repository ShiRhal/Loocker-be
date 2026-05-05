package com.locker.be.web.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AuthDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GoogleLoginReq {
        private String idToken;
    }

    @Getter
    @AllArgsConstructor
    public static class GoogleLoginRes {
        private Long userId;
        private String nickname;
        private String resultCode;
        private String resultMessage;
        private String accessToken;
    }

    @Getter
    @AllArgsConstructor
    public static class MeRes {
        private Long userId;
        private String nickname;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GoogleUserUpsertParam {
        private String providerType;
        private String providerKey;
        private String nickname;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class UserInfo {
        private Long userId;
        private String nickname;
        private String resultCode;
        private String resultMessage;
    }
}