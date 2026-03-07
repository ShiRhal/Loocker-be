package com.locker.be.user.dto;

import lombok.*;

public class UserDto {

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserRes {
        private Long USER_ID;
        private String PROVIDER_TYPE;
        private String PROVIDER_KEY;
        private String NICKNAME;
        private String ROLE_CODE;
        private String STATUS_CODE;
        private String CREATED_AT;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserUpdateReq {
        private Long USER_ID;
        private String NICKNAME;

        @Builder
        public UserUpdateReq (
                Long USER_ID,
                String NICKNAME
        ) {
            this.USER_ID = USER_ID;
            this.NICKNAME = NICKNAME;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserBannedReq {
        private Long USER_ID;

        @Builder
        public UserBannedReq (
                Long USER_ID
        ) {
            this.USER_ID = USER_ID;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserDeleteReq {
        private Long USER_ID;

        @Builder
        public UserDeleteReq (
                Long USER_ID
        ) {
            this.USER_ID = USER_ID;
        }
    }
}
