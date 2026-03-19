package com.locker.be.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserAccountDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAccountCreateReq {
        private Long USER_ID;
        private String BANK_NAME;
        private String ACCOUNT_NUMBER;

        @Builder
        public UserAccountCreateReq (
                Long USER_ID,
                String BANK_NAME,
                String ACCOUNT_NUMBER
        ) {
            this.USER_ID = USER_ID;
            this.BANK_NAME = BANK_NAME;
            this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAccountUpdateReq {
        private Long USER_ID;
        private Long ACCOUNT_ID;
        private String BANK_NAME;
        private String ACCOUNT_NUMBER;
        private Boolean IS_DEFAULT;

        @Builder
        public UserAccountUpdateReq (
                Long USER_ID,
                Long ACCOUNT_ID,
                String BANK_NAME,
                String ACCOUNT_NUMBER,
                Boolean IS_DEFAULT
        ) {
            this.USER_ID = USER_ID;
            this.ACCOUNT_ID = ACCOUNT_ID;
            this.BANK_NAME = BANK_NAME;
            this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
            this.IS_DEFAULT = IS_DEFAULT;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAccountDeleteReq {
        private Long USER_ID;
        private Long ACCOUNT_ID;

        @Builder
        public UserAccountDeleteReq (
                Long USER_ID,
                Long ACCOUNT_ID
        ) {
            this.USER_ID = USER_ID;
            this.ACCOUNT_ID = ACCOUNT_ID;
        }
    }

}
