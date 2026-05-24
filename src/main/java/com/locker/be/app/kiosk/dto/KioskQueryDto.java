package com.locker.be.app.kiosk.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class KioskQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskInfoRes {
        private Long KIOSK_ID;
        private String LOGIN_ID;
        private String STATE;
        private String CITY;
        private String BRANCH_NAME;
        private String DETAIL_ADDRESS;
        private String KIOSK_CODE;
        private Long LOCKER_COUNT;

        private String KIOSK_ACCESS_TOKEN;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class KioskLoginReq {
        private String LOGIN_ID;
        private String LOGIN_PW;

        @Builder
        public KioskLoginReq(
                String LOGIN_ID,
                String LOGIN_PW
        ) {
            this.LOGIN_ID = LOGIN_ID;
            this.LOGIN_PW = LOGIN_PW;
        }
    }

}
