package com.locker.be.web.trade.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class TradeLockerLocationQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TradeLockerLocationRes {
        private Long KIOSK_ID;
        private Double LATITUDE;
        private Double LONGITUDE;
        private String DETAIL_ADDRESS;
        private String BRANCH_NAME;
        private String STATUS_CODE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TradeLockerLocationReq {
        private Long TRADE_ID;
        private Long USER_ID;

        @Builder
        public TradeLockerLocationReq (
                Long TRADE_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.USER_ID = USER_ID;
        }
    }

}
