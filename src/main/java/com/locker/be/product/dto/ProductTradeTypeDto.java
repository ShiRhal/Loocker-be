package com.locker.be.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class ProductTradeTypeDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductTradeTypeRes {
        private Long PRODUCT_ID;
        private String TRADE_TYPE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductTradeTypeReq {
        private Long PRODUCT_ID;
        private String TRADE_TYPE;

        @Builder
        public ProductTradeTypeReq (
                Long PRODUCT_ID,
                String TRADE_TYPE
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.TRADE_TYPE = TRADE_TYPE;
        }
    }
}
