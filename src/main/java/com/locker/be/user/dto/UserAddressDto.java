package com.locker.be.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserAddressDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAddressCreateReq {
        private Long USER_ID;
        private String ADDRESS;

        @Builder
        public UserAddressCreateReq (
                Long USER_ID,
                String ADDRESS
        ) {
            this.USER_ID = USER_ID;
            this.ADDRESS = ADDRESS;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAddressUpdateReq {
        private Long USER_ID;
        private Long ADDRESS_ID;
        private String ADDRESS;
        private Boolean IS_DEFAULT;

        @Builder
        public UserAddressUpdateReq (
                Long USER_ID,
                Long ADDRESS_ID,
                String ADDRESS,
                Boolean IS_DEFAULT
        ) {
            this.USER_ID = USER_ID;
            this.ADDRESS_ID = ADDRESS_ID;
            this.ADDRESS = ADDRESS;
            this.IS_DEFAULT = IS_DEFAULT;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAddressDeleteReq {
        private Long USER_ID;
        private Long ADDRESS_ID;

        @Builder
        public UserAddressDeleteReq (
                Long USER_ID,
                Long ADDRESS_ID
        ) {
            this.USER_ID = USER_ID;
            this.ADDRESS_ID = ADDRESS_ID;
        }
    }
}
