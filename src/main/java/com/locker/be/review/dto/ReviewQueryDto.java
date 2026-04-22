package com.locker.be.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class ReviewQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewRes {
        private Long REVIEW_ID;
        private Long TRADE_ID;
        private Long PRODUCT_ID;
        private String WRITER_NICKNAME;
        private Long SCORE;
        private String CONTENT;
        private String CREATED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewReq {
        private Long PRODUCT_ID;

        @Builder
        public ReviewReq(
                Long PRODUCT_ID
        ) {
            this.PRODUCT_ID = PRODUCT_ID;
        }
    }

}
