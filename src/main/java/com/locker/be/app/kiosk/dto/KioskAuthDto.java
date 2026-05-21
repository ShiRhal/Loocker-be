package com.locker.be.app.kiosk.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class KioskAuthDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskAuthCreateReq {
        private Long KIOSK_ID;
        private String KIOSK_CODE;
        private String AUTH_TYPE_CODE;
        private String AUTH_CODE;

        @Builder
        public KioskAuthCreateReq(
                Long KIOSK_ID,
                String KIOSK_CODE,
                String AUTH_TYPE_CODE,
                String AUTH_CODE
        ) {
            this.KIOSK_ID = KIOSK_ID;
            this.KIOSK_CODE = KIOSK_CODE;
            this.AUTH_TYPE_CODE = AUTH_TYPE_CODE;
            this.AUTH_CODE = AUTH_CODE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskAuthUpdateReq {
        private String AUTH_CODE;
        private Long USER_ID;

        @Builder
        public KioskAuthUpdateReq(
                String AUTH_CODE,
                Long USER_ID
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.USER_ID = USER_ID;
        }
    }

}
