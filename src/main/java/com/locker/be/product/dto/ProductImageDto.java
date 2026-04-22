package com.locker.be.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

public class ProductImageDto {

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
        private Boolean IS_ACTIVE;
        private String CREATED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class ProductImageCreateReq {
        private Long PRODUCT_ID;
        private String IMAGE_URL;
        private Long SORT_ORDER;
        private Boolean IS_PRIMARY;
        private Boolean IS_ACTIVE;
        private MultipartFile[] files;

        @Builder
        public ProductImageCreateReq (
                Long PRODUCT_ID,
                String IMAGE_URL,
                Long SORT_ORDER,
                Boolean IS_PRIMARY,
                Boolean IS_ACTIVE,
                MultipartFile[] files
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.IMAGE_URL = IMAGE_URL;
            this.SORT_ORDER = SORT_ORDER;
            this.IS_PRIMARY = IS_PRIMARY;
            this.IS_ACTIVE = IS_ACTIVE;
            this.files = files;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class ProductImageDeleteReq {
        private Long PRODUCT_ID;

        @Builder
        public ProductImageDeleteReq (
                Long PRODUCT_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }
}
