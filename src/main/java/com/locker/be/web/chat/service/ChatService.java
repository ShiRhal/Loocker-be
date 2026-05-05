package com.locker.be.web.chat.service;

import com.locker.be.web.chat.dto.ChatMessageDto;
import com.locker.be.web.chat.dto.ChatRoomDto;
import com.locker.be.web.chat.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMapper chatMapper;

    public List<ChatRoomDto.RoomListItem> listRoomsForUser(long userId) {
        return chatMapper.selectRooms(userId);
    }

    public ChatRoomDto.ChatRoom createOrGetRoom(long userId, ChatRoomDto.RoomInsertReq req) {
        if (req == null || req.getPRODUCT_ID() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "productId is required");
        }

        ChatRoomDto.RoomInsertParam param = new ChatRoomDto.RoomInsertParam(req.getPRODUCT_ID(), userId, null);
        chatMapper.insertRoom(param);
        if (param.getNEW_ID() == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create or load chat room");
        }

        Optional<ChatRoomDto.RoomListItem> found = chatMapper.selectRooms(userId).stream()
                .filter(room -> param.getNEW_ID().equals(room.getCHAT_ROOM_ID()))
                .findFirst();

        if (found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Created chat room not found");
        }

        ChatRoomDto.RoomListItem item = found.get();
        return ChatRoomDto.ChatRoom.builder()
                .CHAT_ROOM_ID(item.getCHAT_ROOM_ID())
                .PRODUCT_ID(item.getPRODUCT_ID())
                .SELLER_ID(item.getSELLER_ID())
                .BUYER_ID(item.getBUYER_ID())
                .CREATED_AT(item.getCREATED_AT())
                .build();
    }

    public void exitRoom(long roomId, long userId) {
        chatMapper.exitRoom(new ChatRoomDto.RoomExitParam(roomId, userId));
    }

    public List<ChatMessageDto.ChatMessage> listMessages(long roomId, long userId) {
        return chatMapper.selectMessages(new ChatMessageDto.MessageSelectParam(roomId, userId, 0L, 200));
    }

    public ChatMessageDto.ChatMessage saveAndBuildMessage(long roomId, long senderId, String rawMessage) {
        String message = rawMessage == null ? "" : rawMessage.trim();
        if (message.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message must not be empty");
        }

        int affected = chatMapper.insertMessage(
                new ChatMessageDto.MessageInsertParam(roomId, senderId, message)
        );
        if (affected <= 0) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to insert chat message");
        }

        List<ChatMessageDto.ChatMessage> latestBatch = chatMapper.selectMessages(
                new ChatMessageDto.MessageSelectParam(roomId, senderId, 0L, 200)
        );
        if (!latestBatch.isEmpty()) {
            return latestBatch.stream()
                    .max(Comparator.comparing(
                            ChatMessageDto.ChatMessage::getCHAT_MESSAGE_ID,
                            Comparator.nullsLast(Comparator.naturalOrder())
                    ))
                    .orElse(latestBatch.get(latestBatch.size() - 1));
        }

        return ChatMessageDto.ChatMessage.builder()
                .CHAT_ROOM_ID(roomId)
                .SENDER_ID(senderId)
                .MESSAGE(message)
                .build();
    }
}
