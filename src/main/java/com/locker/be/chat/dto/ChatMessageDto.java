package com.locker.be.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public final class ChatMessageDto {

    private ChatMessageDto() {
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatMessage {
        private Long CHAT_MESSAGE_ID;
        private Long CHAT_ROOM_ID;
        private Long SENDER_ID;
        private String MESSAGE;
        private String CREATED_AT;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SendReq {
        private String MESSAGE;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageSelectParam {
        private Long CHAT_ROOM_ID;
        private Long USER_ID;
        private Long LAST_CHAT_MESSAGE_ID;
        private Integer PAGE_SIZE;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageInsertParam {
        private Long CHAT_ROOM_ID;
        private Long SENDER_ID;
        private String MESSAGE;
    }
}
