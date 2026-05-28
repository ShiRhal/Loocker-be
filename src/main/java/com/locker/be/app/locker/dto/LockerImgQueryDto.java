package com.locker.be.app.locker.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class LockerImgQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerImgRes {
        private Long TRADE_ID;
        private Long LOCKER_ID;
        private String SELLER_IMAGE_URL;
        private String BUYER_IMAGE_URL;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerImgReq {
        private String LOCKER_CODE;
        private String KIOSK_CODE;
        private Long TRADE_ID;
        private Long LOCKER_ID;

        @Builder
        public LockerImgReq(
                String LOCKER_CODE,
                String KIOSK_CODE,
                Long TRADE_ID,
                Long LOCKER_ID
        ) {
            this.LOCKER_CODE = LOCKER_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
            this.TRADE_ID = TRADE_ID;
            this.LOCKER_ID = LOCKER_ID;
        }
    }

}
