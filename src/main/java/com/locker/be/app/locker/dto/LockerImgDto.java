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
        private String LOCKER_CODE;
        private String IMAGE_TYPE_CODE;
        private MultipartFile IMAGE_FILE;

        @Builder
        public LockerImgCreateReq(
                String LOCKER_CODE,
                String IMAGE_TYPE_CODE,
                MultipartFile IMAGE_FILE
        ) {
            this.LOCKER_CODE = LOCKER_CODE;
            this.IMAGE_TYPE_CODE = IMAGE_TYPE_CODE;
            this.IMAGE_FILE = IMAGE_FILE;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class LockerImgCreateParam {
        private String LOCKER_CODE;
        private String IMAGE_TYPE_CODE;
        private String IMAGE_URL;

        @Builder
        public LockerImgCreateParam(
                String LOCKER_CODE,
                String IMAGE_TYPE_CODE,
                String IMAGE_URL
        ) {
            this.LOCKER_CODE = LOCKER_CODE;
            this.IMAGE_TYPE_CODE = IMAGE_TYPE_CODE;
            this.IMAGE_URL = IMAGE_URL;
        }
    }
}