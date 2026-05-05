package com.locker.be.web.payment.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class PaymentDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PaymentCreateReq {
        private Long TRADE_ID;
        private Long PRODUCT_ID;
        private Long USER_ID;

        @Builder
        public PaymentCreateReq (
                Long TRADE_ID,
                Long PRODUCT_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.PRODUCT_ID = PRODUCT_ID;
            this.USER_ID = USER_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PaymentPaidReq {
        private Long TRADE_ID;
        private Long AMOUNT;
        private String ORDER_ID;
        private String PAYMENT_KEY;
        private Long USER_ID;
        private Long SUCCESS;

        @Builder
        public PaymentPaidReq (
                Long TRADE_ID,
                Long AMOUNT,
                String ORDER_ID,
                String PAYMENT_KEY,
                Long USER_ID,
                Long SUCCESS
        ) {
            this.TRADE_ID = TRADE_ID;
            this.AMOUNT = AMOUNT;
            this.ORDER_ID = ORDER_ID;
            this.PAYMENT_KEY = PAYMENT_KEY;
            this.USER_ID = USER_ID;
            this.SUCCESS = SUCCESS;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PaymentCanceledReq {
        private Long TRADE_ID;
        private String ORDER_ID;
        private Long USER_ID;

        @Builder
        public PaymentCanceledReq (
                Long TRADE_ID,
                String ORDER_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.ORDER_ID = ORDER_ID;
            this.USER_ID = USER_ID;
        }
    }

}
