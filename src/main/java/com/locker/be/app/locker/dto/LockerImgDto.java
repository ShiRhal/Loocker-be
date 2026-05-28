package com.locker.be.app.locker.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

public class LockerImgDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LockerImgCreateReq {
        private Long TRADE_ID;
        private Long LOCKER_ID;
        private String IMAGE_TYPE_CODE;
        private MultipartFile IMAGE_FILE;

        @Builder
        public LockerImgCreateReq(
                Long TRADE_ID,
                Long LOCKER_ID,
                String IMAGE_TYPE_CODE,
                MultipartFile IMAGE_FILE
        ) {
            this.TRADE_ID = TRADE_ID;
            this.LOCKER_ID = LOCKER_ID;
            this.IMAGE_TYPE_CODE = IMAGE_TYPE_CODE;
            this.IMAGE_FILE = IMAGE_FILE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class LockerImgCreateParam {
        private Long TRADE_ID;
        private Long LOCKER_ID;
        private String IMAGE_TYPE_CODE;
        private String IMAGE_URL;

        @Builder
        public LockerImgCreateParam(
                Long TRADE_ID,
                Long LOCKER_ID,
                String IMAGE_TYPE_CODE,
                String IMAGE_URL
        ) {
            this.TRADE_ID = TRADE_ID;
            this.LOCKER_ID = LOCKER_ID;
            this.IMAGE_TYPE_CODE = IMAGE_TYPE_CODE;
            this.IMAGE_URL = IMAGE_URL;
        }
    }
}