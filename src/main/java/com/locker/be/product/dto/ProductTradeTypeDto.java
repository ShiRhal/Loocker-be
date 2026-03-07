package com.locker.be.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductTradeTypeDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProductTradeTypeRes {
        private Long PRODUCT_ID;
        private String TRADE_TYPE;
    }

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
