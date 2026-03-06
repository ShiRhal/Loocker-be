package com.locker.be.user.dto;

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
        private String providerType;
        private String providerKey;
    }

    @Getter
    @AllArgsConstructor
    public static class MeRes {
        private Long userId;
        private String nickname;
        private String providerType;
    }
}