package com.locker.be.app.kiosk.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class KioskAuthQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskAuthRes {
        private String AUTH_CODE;
        private String AUTH_STATUS_CODE;
        private String AUTH_RESULT_TIME;
        private String AUTH_TYPE_CODE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskAuthReq {
        private String AUTH_CODE;
        private String KIOSK_CODE;

        @Builder
        public KioskAuthReq(
                String AUTH_CODE,
                String KIOSK_CODE
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
        }
    }

}
