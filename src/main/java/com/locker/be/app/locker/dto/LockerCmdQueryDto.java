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

}
