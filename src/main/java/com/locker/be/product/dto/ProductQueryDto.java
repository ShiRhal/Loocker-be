package com.locker.be.product.dto;

import lombok.*;

public class ProductQueryDto {

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductRes {
        private Long PRODUCT_ID;
        private String IMAGE_URL;
        private String TITLE;
        private String BASE_PRICE;
        private String CITY;
        private String CREATED_AT;
        private String LOCKER_BADGE;
        private Long WISH_COUNT;
        private Long CHAT_COUNT;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductReq {
        private String DS_TITLE;
        private String DS_MAIN_CATEGORY;
        private String DS_SUB_CATEGORY;
        private Long MIN_PRICE;
        private Long MAX_PRICE;
        private Boolean YN_SOLDED;
        private Boolean YN_LOCKER;
        private String DS_STATE;
        private String DS_CITY;
        private Long PAGE;

        @Builder
        public ProductReq (
                String DS_TITLE,
                String DS_MAIN_CATEGORY,
                String DS_SUB_CATEGORY,
                Long MIN_PRICE,
                Long MAX_PRICE,
                Boolean YN_SOLDED,
                Boolean YN_LOCKER,
                String DS_STATE,
                String DS_CITY,
                Long PAGE
        ) {
            this.DS_TITLE = DS_TITLE;
            this.DS_MAIN_CATEGORY = DS_MAIN_CATEGORY;
            this.DS_SUB_CATEGORY = DS_SUB_CATEGORY;
            this.MIN_PRICE = MIN_PRICE;
            this.MAX_PRICE = MAX_PRICE;
            this.YN_SOLDED = YN_SOLDED;
            this.YN_LOCKER = YN_LOCKER;
            this.DS_STATE = DS_STATE;
            this.DS_CITY = DS_CITY;
            this.PAGE = PAGE;
        }
    }
}
