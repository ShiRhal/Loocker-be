package com.locker.be.app.kiosk.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class KioskSellerQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskLockerRes {
        private Long LOCKER_ID;
        private String LOCKER_STATUS_CODE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskLockerReq {
        private String AUTH_CODE;
        private Long PRODUCT_ID;
        private String KIOSK_CODE;

        @Builder
        public KioskLockerReq(
                String AUTH_CODE,
                Long PRODUCT_ID,
                String KIOSK_CODE
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.PRODUCT_ID = PRODUCT_ID;
            this.KIOSK_CODE = KIOSK_CODE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskProductRes {
        private Long PRODUCT_ID;
        private String TITLE;
        private Long BASE_PRICE;
        private String PRODUCT_STATUS_CODE;
        private String CREATED_AT;
        private String IMAGE_URL;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskProductReq {
        private String AUTH_CODE;
        private String KIOSK_CODE;

        @Builder
        public KioskProductReq(
                String AUTH_CODE,
                String KIOSK_CODE
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
        }
    }

}
