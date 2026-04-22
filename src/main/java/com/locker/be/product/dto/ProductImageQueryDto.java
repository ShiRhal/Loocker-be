package com.locker.be.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class ProductImageQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductImageRes {
        private Long IMAGE_ID;
        private Long PRODUCT_ID;
        private String IMAGE_URL;
        private Long SORT_ORDER;
        private Boolean IS_PRIMARY;
        private String CREATED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class ProductImageReq {
        private Long PRODUCT_ID;

        @Builder
        public ProductImageReq (
                Long PRODUCT_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductPriImageRes {
        private String IMAGE_URL;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class ProductPriImageReq {
        private Long PRODUCT_ID;

        @Builder
        public ProductPriImageReq (
                Long PRODUCT_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }
}
