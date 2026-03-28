package com.locker.be.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class UserWishlistDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
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
