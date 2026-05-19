package com.locker.be.app.locker.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class LockerDto {


    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerCreateReq {
        private Long TRADE_ID;
        private Long USER_ID;
        private Long LOCKER_ID;
        private String RESULT_STATUS_CODE;

        @Builder
        public LockerCreateReq (
                Long TRADE_ID,
                Long USER_ID,
                Long LOCKER_ID,
                String RESULT_STATUS_CODE
        ) {
            this.TRADE_ID = TRADE_ID;
            this.USER_ID = USER_ID;
            this.LOCKER_ID = LOCKER_ID;
            this.RESULT_STATUS_CODE = RESULT_STATUS_CODE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerUpdateReq {
        private Long TRADE_ID;
        private Long USER_ID;
        private String NEXT_STATUS;
        private String ROLE_TYPE;
        private String RESULT_STATUS_CODE;

        @Builder
        public LockerUpdateReq (
                Long TRADE_ID,
                Long USER_ID,
                String NEXT_STATUS,
                String ROLE_TYPE,
                String RESULT_STATUS_CODE
        ) {
            this.TRADE_ID = TRADE_ID;
            this.USER_ID = USER_ID;
            this.NEXT_STATUS = NEXT_STATUS;
            this.ROLE_TYPE = ROLE_TYPE;
            this.RESULT_STATUS_CODE = RESULT_STATUS_CODE;
        }
    }

}
