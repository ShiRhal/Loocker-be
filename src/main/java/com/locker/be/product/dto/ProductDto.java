package com.locker.be.product.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductRes {
        private Long PRODUCT_ID;
        private String IMAGE_URL;
        private String TITLE;
        private String BASE_PRICE;
        private String CITY;
        private String CREATED_AT;
        private String LOCKER_BADGE;
        private Integer WISH_COUNT;
        private Integer CHAT_COUNT;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductReq {

    }
}
