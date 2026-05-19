package com.locker.be.app.kiosk.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class KioskBuyerQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskLockerRes {
        private Long LOCKER_ID;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskLockerReq {
        private Long TRADE_ID;
        private Long USER_ID;

        @Builder
        public KioskLockerReq(
                Long TRADE_ID,
                Long USER_ID
        ) {
            this.TRADE_ID = TRADE_ID;
            this.USER_ID = USER_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskProductRes {
        private Long PRODUCT_ID;
        private Long TRADE_ID;
        private Long TRADE_STATUS_CODE;
        private Long LOCKER_ID;

        private String TITLE;
        private Long BASE_PRICE;
        private String PRODUCT_STATUS_CODE;
        private String CREATED_AT;
        private String IMAGE_URL;
        private String LOCKER_STATUS_CODE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskProductReq {
        private Long USER_ID;
        private String KIOSK_CODE;

        @Builder
        public KioskProductReq(
                Long USER_ID,
                String KIOSK_CODE
        ) {
            this.USER_ID = USER_ID;
            this.KIOSK_CODE = KIOSK_CODE;
        }
    }

}
