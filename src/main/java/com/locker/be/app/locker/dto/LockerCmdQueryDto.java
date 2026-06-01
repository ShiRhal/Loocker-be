package com.locker.be.app.locker.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class LockerCmdQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCmdRes {
        private Long LOCKER_COMMAND_ID;
        private String COMMAND_TYPE_CODE;
        private String COMMAND_STATUS_CODE;
        private String REQUESTED_AT;
        private String PICKED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCmdReq {
        private String LOCKER_CODE;

        @Builder
        public LockerCmdReq(
                String LOCKER_CODE
        ) {
            this.LOCKER_CODE = LOCKER_CODE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCmdStatusRes {
        private String CHECK_STATUS;
        private String CAN_RETRY;
        private String FAILED_COMMAND_TYPE_CODE;
        private String RESULT_MESSAGE;
        private String LOCKER_STATUS;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCmdStatusReq {
        private String AUTH_CODE;
        private String KIOSK_CODE;
        private Long LOCKER_ID;
        private String LOCKER_STATUS_NAME;

        @Builder
        public LockerCmdStatusReq(
                String AUTH_CODE,
                String KIOSK_CODE,
                Long LOCKER_ID,
                String LOCKER_STATUS_NAME
                ) {
            this.AUTH_CODE = AUTH_CODE;
            this.KIOSK_CODE = KIOSK_CODE;
            this.LOCKER_ID = LOCKER_ID;
            this.LOCKER_STATUS_NAME = LOCKER_STATUS_NAME;
        }
    }

}
