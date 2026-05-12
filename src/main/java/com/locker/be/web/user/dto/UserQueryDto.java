package com.locker.be.web.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.locker.be.CustomUpperSnakeCaseStrategy;
import lombok.*;

import java.util.Collection;

public class UserQueryDto {

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class UserInfoRes {
        private UserQueryDto.UserRes USER;
        private Collection<UserProductRes> PRODUCT;
        private Collection<UserWishlistRes> WISHLIST;
        private Collection<UserAccountRes> ACCOUNT;
        private Collection<UserAddressRes> ADDRESS;
        private Collection<UserSaleRes> SALELIST;
        private Collection<UserBuyRes> BUYLIST;
        private Collection<UserReviewRes> REVIEW;
        private Collection<UserTradeRes> TRADE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserRes {
        private Long USER_ID;
        private String NICKNAME;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserProductRes {
        private Long PRODUCT_ID;
        private String TITLE;
        private String IMAGE_URL;
        private Long BASE_PRICE;
        private String PRODUCT_STATUS_CODE;
        private Long VIEW_COUNT;
        private String CREATED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserWishlistRes {
        private Long PRODUCT_ID;
        private String TITLE;
        private String IMAGE_URL;
        private Long BASE_PRICE;
        private String PRODUCT_STATUS_CODE;
        private Long VIEW_COUNT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAccountRes {
        private Long ACCOUNT_ID;
        private String BANK_NAME;
        private String ACCOUNT_NUMBER;
        private Boolean IS_DEFAULT;
        private Boolean IS_ACTIVE;
        private String CREATED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserAddressRes {
        private Long ADDRESS_ID;
        private String ADDRESS;
        private Boolean IS_DEFAULT;
        private Boolean IS_ACTIVE;
        private String CREATED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserSaleRes {
        private Long PRODUCT_ID;
        private String TITLE;
        private String IMAGE_URL;
        private String PRODUCT_STATUS_CODE;
        private Long BASE_PRICE;
        private Long VIEW_COUNT;
        private String BUYER_NICKNAME;
        private String COMPLETED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserBuyRes {
        private Long PRODUCT_ID;
        private String TITLE;
        private String IMAGE_URL;
        private String PRODUCT_STATUS_CODE;
        private Long BASE_PRICE;
        private Long VIEW_COUNT;
        private String SELLER_NICKNAME;
        private String COMPLETED_AT;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserReviewRes {
        private Long REVIEW_ID;
        private Long TRADE_ID;
        private Long PRODUCT_ID;
        private String WRITER_NICKNAME;
        private String TARGET_USER_NICKNAME;
        private Long SCORE;
        private String CONTENT;
        private String CREATED_AT;
        private String REVIEW_TYPE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserTradeRes {
        private Long TRADE_ID;
        private Long PRODUCT_ID;
        private String TITLE;
        private String IMAGE_URL;
        private Long BASE_PRICE;
        private String SELLER_NICKNAME;
        private String CREATED_AT;
        private Long VIEW_COUNT;
        private Long CHAT_COUNT;
        private Long WISH_COUNT;
        private String TRADE_TYPE_CODE;
        private String STATUS_CODE;
        private String MY_ROLE;
    }

    @JsonNaming(CustomUpperSnakeCaseStrategy.class)
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class UserInfoReq {
        private Long USER_ID;

        @Builder
        public UserInfoReq (
                Long USER_ID
        ) {
            this.USER_ID = USER_ID;
        }
    }

}
