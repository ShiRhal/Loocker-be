package com.locker.be.web.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

public class ReviewDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewCreateReq {
        private Long USER_ID;
        private Long PRODUCT_ID;
        private Long SCORE;
        private String CONTENT;
        private Long NEW_REVIEW_ID;

        @Builder
        public ReviewCreateReq(
                Long USER_ID,
                Long PRODUCT_ID,
                Long SCORE,
                String CONTENT,
                Long NEW_REVIEW_ID
        ) {
            this.USER_ID = USER_ID;
            this.PRODUCT_ID = PRODUCT_ID;
            this.SCORE = SCORE;
            this.CONTENT = CONTENT;
            this.NEW_REVIEW_ID = NEW_REVIEW_ID;
        }
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewUpdateReq {
        private Long USER_ID;
        private Long REVIEW_ID;
        private Long SCORE;
        private String CONTENT;

        @Builder
        public ReviewUpdateReq(
                Long USER_ID,
                Long REVIEW_ID,
                Long SCORE,
                String CONTENT
        ) {
            this.USER_ID = USER_ID;
            this.REVIEW_ID = REVIEW_ID;
            this.SCORE = SCORE;
            this.CONTENT = CONTENT;
        }
    }

}