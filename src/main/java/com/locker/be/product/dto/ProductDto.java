package com.locker.be.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductDetailRes {
        private Long PRODUCT_ID;
        private String TITLE;
        private String DESCRIPTION;
        private Long BASE_PRICE;
        private String STATUS_CODE;
        private String ACCESSORY_STATUS;
        private String STATE;
        private String CITY;
        private String MAIN_CATEGORY;
        private String SUB_CATEGORY;
        private String CREATED_AT;
        private String NICKNAME;
        private Long VIEW_COUNT;
        private String IMAGE_URL;
        private String TRADE_TYPE;
        private Long WISH_COUNT;
        private Long CHAT_COUNT;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductDetailReq {
        private String TITLE;
        private String DESCRIPTION;
        private String BASE_PRICE;
        private String ACCESSORY_STATUS;
        private String CITY;
        private String SUB_CATEGORY;
        private String NICKNAME;
        private String TRADE_TYPE;
        private Long NewID;

        @Builder
        public ProductDetailReq (
                String TITLE,
                String DESCRIPTION,
                String BASE_PRICE,
                String ACCESSORY_STATUS,
                String CITY,
                String SUB_CATEGORY,
                String NICKNAME,
                String TRADE_TYPE,
                Long NewID
        ) {
            this.TITLE = TITLE;
            this.DESCRIPTION = DESCRIPTION;
            this.BASE_PRICE = BASE_PRICE;
            this.ACCESSORY_STATUS = ACCESSORY_STATUS;
            this.CITY = CITY;
            this.SUB_CATEGORY = SUB_CATEGORY;
            this.NICKNAME = NICKNAME;
            this.TRADE_TYPE = TRADE_TYPE;
            this.NewID = NewID;
        }
    }
}
