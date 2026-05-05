package com.locker.be.web.chat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public final class ChatRoomDto {

    private ChatRoomDto() {
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatRoom {
        private Long CHAT_ROOM_ID;
        private Long PRODUCT_ID;
        private Long SELLER_ID;
        private Long BUYER_ID;
        private String CREATED_AT;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class RoomListItem {
        private Long CHAT_ROOM_ID;
        private Long PRODUCT_ID;
        private Long SELLER_ID;
        private Long BUYER_ID;
        private String TITLE;
        private Long TARGET_USER_ID;
        private String TARGET_NICKNAME;
        private String IMAGE_URL;
        private String CREATED_AT;
        private String LAST_MESSAGE;
        private String LAST_CHAT_TIME;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoomInsertReq {
        private Long PRODUCT_ID;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoomInsertParam {
        private Long PRODUCT_ID;
        private Long USER_ID;
        private Long NEW_ID;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoomExitParam {
        private Long CHAT_ROOM_ID;
        private Long USER_ID;
    }
}
