package com.locker.be.web.admin.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class AdminQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AdminRes {
        private String ADMIN_ID;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AdminReq {
        private String ADMIN_ID;
        private String ADMIN_PW;

        @Builder
        public AdminReq(
                String ADMIN_ID,
                String ADMIN_PW
        ) {
            this.ADMIN_ID = ADMIN_ID;
            this.ADMIN_PW = ADMIN_PW;
        }
    }

}
