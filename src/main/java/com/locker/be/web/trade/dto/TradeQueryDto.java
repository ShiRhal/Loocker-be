package com.locker.be.web.trade.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class TradeQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TradeIdRes {
        private String TRADE_ID;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeIdReq {
        private Long PRODUCT_ID;
        private Long USER_ID;

        @Builder
        public TradeIdReq (
            Long PRODUCT_ID,
            Long USER_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.USER_ID = USER_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TradeRes {
        private Long TRADE_ID;
        private Long PRODUCT_ID;
        private String TRADE_TYPE_CODE;
        private String STATUS_CODE;
        private String MY_ROLE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeReq {
        private Long PRODUCT_ID;
        private Long USER_ID;

        @Builder
        public TradeReq (
                Long PRODUCT_ID,
                Long USER_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.USER_ID = USER_ID;
        }
    }

}
