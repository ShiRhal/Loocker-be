package com.locker.be.search.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class SearchQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SearchRes {
        private String KEYWORD;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    public static class SearchReq {

        @Builder
        public SearchReq (

        ) {

        }
    }

}
