package com.locker.be.search.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class SearchDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SearchReq {
        private Long USER_ID;
        private String KEYWORD;

        @Builder
        public SearchReq (
                Long USER_ID,
                String KEYWORD
        ) {
            this.USER_ID = USER_ID;
            this.KEYWORD = KEYWORD;
        }
    }

}
