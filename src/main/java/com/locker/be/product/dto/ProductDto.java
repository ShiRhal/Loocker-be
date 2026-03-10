package com.locker.be.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

public class ProductDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
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

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductDetailCreateReq {
        private String TITLE;
        private String DESCRIPTION;
        private Long BASE_PRICE;
        private String ACCESSORY_STATUS;
        private String CITY;
        private String SUB_CATEGORY;
        private String NICKNAME;
        private String TRADE_TYPE;
        private Long NewID;
        private MultipartFile[] files;

        @Builder
        public ProductDetailCreateReq (
                String TITLE,
                String DESCRIPTION,
                Long BASE_PRICE,
                String ACCESSORY_STATUS,
                String CITY,
                String SUB_CATEGORY,
                String NICKNAME,
                String TRADE_TYPE,
                Long NewID,
                MultipartFile[] files
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
            this.files = files;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductDetailUpdateReq {
        private Long PRODUCT_ID;
        private String TITLE;
        private String DESCRIPTION;
        private Long BASE_PRICE;
        private String ACCESSORY_STATUS;
        private String CITY;
        private String SUB_CATEGORY;
        private String TRADE_TYPE;
        private MultipartFile[] files;

        @Builder
        public ProductDetailUpdateReq (
                Long PRODUCT_ID,
                String TITLE,
                String DESCRIPTION,
                Long BASE_PRICE,
                String ACCESSORY_STATUS,
                String CITY,
                String SUB_CATEGORY,
                String TRADE_TYPE,
                MultipartFile[] files
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.TITLE = TITLE;
            this.DESCRIPTION = DESCRIPTION;
            this. BASE_PRICE = BASE_PRICE;
            this.ACCESSORY_STATUS = ACCESSORY_STATUS;
            this.CITY = CITY;
            this.SUB_CATEGORY = SUB_CATEGORY;
            this.TRADE_TYPE = TRADE_TYPE;
            this.files = files;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductDetailDeleteReq {
        private Long PRODUCT_ID;

        @Builder
        public ProductDetailDeleteReq (
                Long PRODUCT_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }
}
