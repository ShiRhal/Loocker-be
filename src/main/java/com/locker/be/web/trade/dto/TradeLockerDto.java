package com.locker.be.web.trade.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class TradeLockerDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeLockerLocationCreateReq {
        private Long TRADE_ID;
        private Long KIOSK_ID;
        private Long USER_ID;

        @Builder
        public TradeLockerLocationCreateReq (
                Long TRADE_ID,
                Long KIOSK_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.KIOSK_ID = KIOSK_ID;
            this.USER_ID = USER_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeLockerLocationUpdateReq {
        private Long TRADE_ID;
        private Long KIOSK_ID;
        private Long USER_ID;

        @Builder
        public TradeLockerLocationUpdateReq (
                Long TRADE_ID,
                Long KIOSK_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.KIOSK_ID = KIOSK_ID;
            this.USER_ID = USER_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeLockerLocationDeleteReq {
        private Long TRADE_ID;
        private Long USER_ID;

        @Builder
        public TradeLockerLocationDeleteReq (
                Long TRADE_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.USER_ID = USER_ID;
        }
    }

}
