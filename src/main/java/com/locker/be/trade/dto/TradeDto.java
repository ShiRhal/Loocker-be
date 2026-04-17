package com.locker.be.trade.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class TradeDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeInsertReq {
        private Long PRODUCT_ID;
        private Long USER_ID;
        private String TRADE_TYPE_CODE;
        private Long CHAT_ROOM_ID;

        @Builder
        public TradeInsertReq (
                Long PRODUCT_ID,
                Long USER_ID,
                String TRADE_TYPE_CODE,
                Long CHAT_ROOM_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.USER_ID = USER_ID;
            this.TRADE_TYPE_CODE = TRADE_TYPE_CODE;
            this.CHAT_ROOM_ID = CHAT_ROOM_ID;
        }
    }
}
