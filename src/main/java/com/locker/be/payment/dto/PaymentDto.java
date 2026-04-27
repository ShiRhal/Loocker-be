package com.locker.be.payment.dto;

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

}
