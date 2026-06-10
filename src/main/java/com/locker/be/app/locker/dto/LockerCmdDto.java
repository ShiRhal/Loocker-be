package com.locker.be.app.locker.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class LockerCmdDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCmdInsertReq {
        private String AUTH_CODE;
        private String KIOSK_CODE;
        private String NEXT_STATUS;
        private String REQUEST_TYPE_CODE;

        @Builder
        public LockerCmdInsertReq (
                String AUTH_CODE,
                String KIOSK_CODE,
                String NEXT_STATUS,
                String REQUEST_TYPE_CODE
        ) {
            this.AUTH_CODE = AUTH_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
            this.NEXT_STATUS = NEXT_STATUS;
            this.REQUEST_TYPE_CODE = REQUEST_TYPE_CODE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCmdUpdateReq {
        private Long LOCKER_COMMAND_ID;
        private String COMMAND_STATUS_CODE;
        private String RESULT_MESSAGE;

        @Builder
        public LockerCmdUpdateReq (
                Long LOCKER_COMMAND_ID,
                String COMMAND_STATUS_CODE,
                String RESULT_MESSAGE
        ) {
            this.LOCKER_COMMAND_ID = LOCKER_COMMAND_ID;
            this.COMMAND_STATUS_CODE = COMMAND_STATUS_CODE;
            this.RESULT_MESSAGE = RESULT_MESSAGE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerAdminCmdInsertReq {
        private Long LOCKER_ID;
        private String COMMAND_TYPE_CODE;

        @Builder
        public LockerAdminCmdInsertReq (
                Long LOCKER_ID,
                String COMMAND_TYPE_CODE
        ) {
            this.LOCKER_ID = LOCKER_ID;
            this.COMMAND_TYPE_CODE = COMMAND_TYPE_CODE;
        }
    }

}
