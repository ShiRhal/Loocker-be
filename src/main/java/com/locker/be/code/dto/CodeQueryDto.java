package com.locker.be.code.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class CodeQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class StateRes {
        private Long ID;
        private String CODE;
        private String STATE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CityRes {
        private Long ID;
        private Long STATE_ID;
        private String CODE;
        private String CITY;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MainCategoryRes {
        private Long ID;
        private String MAIN_CATEGORY;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SubCategoryRes {
        private Long ID;
        private Long MAIN_ID;
        private String SUB_CATEGORY;
    }

}
