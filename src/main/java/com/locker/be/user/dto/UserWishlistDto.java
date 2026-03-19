package com.locker.be.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserWishlistDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserWishlistSaveReq {
        private Long USER_ID;
        private Long PRODUCT_ID;

        @Builder
        public UserWishlistSaveReq (
                Long USER_ID,
                Long PRODUCT_ID
        ) {
            this.USER_ID = USER_ID;
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }

}
