package com.locker.be.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

import java.util.Collection;

public class ProductQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class ProductAllRes {
        private Collection<ProductRes> PRODUCT_LIST;
        private ProductPriceStatusRes PRICE_STATUS;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductRes {
        private Long PRODUCT_ID;
        private String IMAGE_URL;
        private String TITLE;
        private Long BASE_PRICE;
        private String CITY;
        private String CREATED_AT;
        private String LOCKER_BADGE;
        private Long WISH_COUNT;
        private Long CHAT_COUNT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductPriceStatusRes {
        private Long MIN_PRICE;
        private Long AVG_PRICE;
        private Long MAX_PRICE;
        private Long PRODUCT_COUNT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductReq {
        private Long USER_ID;
        private String DS_TITLE;
        private String DS_MAIN_CATEGORY;
        private String DS_SUB_CATEGORY;
        private Long MIN_PRICE;
        private Long MAX_PRICE;
        private Boolean YN_SOLDED;
        private Boolean YN_LOCKER;
        private String DS_STATE;
        private String DS_CITY;
        private String SORT_TYPE;
        private Long PAGE;

        @Builder
        public ProductReq (
                Long USER_ID,
                String DS_TITLE,
                String DS_MAIN_CATEGORY,
                String DS_SUB_CATEGORY,
                Long MIN_PRICE,
                Long MAX_PRICE,
                Boolean YN_SOLDED,
                Boolean YN_LOCKER,
                String DS_STATE,
                String DS_CITY,
                String SORT_TYPE,
                Long PAGE
        ) {
            this.USER_ID = USER_ID;
            this.DS_TITLE = DS_TITLE;
            this.DS_MAIN_CATEGORY = DS_MAIN_CATEGORY;
            this.DS_SUB_CATEGORY = DS_SUB_CATEGORY;
            this.MIN_PRICE = MIN_PRICE;
            this.MAX_PRICE = MAX_PRICE;
            this.YN_SOLDED = YN_SOLDED;
            this.YN_LOCKER = YN_LOCKER;
            this.DS_STATE = DS_STATE;
            this.DS_CITY = DS_CITY;
            this.SORT_TYPE = SORT_TYPE;
            this.PAGE = PAGE;
        }
    }

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
        private String TRADE_TYPE;
        private Long WISH_COUNT;
        private Long CHAT_COUNT;
        private Collection<ProductImageQueryDto.ProductImageRes> IMAGE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductDetailReq {
        private Long PRODUCT_ID;

        @Builder
        public ProductDetailReq (
                Long PRODUCT_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }
}
