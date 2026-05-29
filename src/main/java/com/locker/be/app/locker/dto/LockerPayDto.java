package com.locker.be.app.locker.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class LockerPayDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerPayCreateReq {
        private String AUTH_CODE;
        private String KIOSK_CODE;
        private Long TRADE_ID;
        private Long PRODUCT_ID;

        @Builder
        public LockerPayCreateReq(
                String AUTH_CODE,
                String KIOSK_CODE,
                Long TRADE_ID,
                Long PRODUCT_ID
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
            this.TRADE_ID = TRADE_ID;
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerPayUpdateReq {
        private String AUTH_CODE;
        private String KIOSK_CODE;
        private Long TRADE_ID;
        private Long AMOUNT;
        private String ORDER_ID;
        private String PAYMENT_KEY;
        private Long SUCCESS;

        @Builder
        public LockerPayUpdateReq(
                String AUTH_CODE,
                String KIOSK_CODE,
                Long TRADE_ID,
                Long AMOUNT,
                String ORDER_ID,
                String PAYMENT_KEY,
                Long SUCCESS
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
            this.TRADE_ID = TRADE_ID;
            this.AMOUNT = AMOUNT;
            this.ORDER_ID = ORDER_ID;
            this.PAYMENT_KEY = PAYMENT_KEY;
            this.SUCCESS = SUCCESS;
        }
    }

}
