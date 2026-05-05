package com.locker.be.web.chat.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.locker.be.web.chat.dto.ChatMessageDto;
import com.locker.be.web.chat.dto.ChatRoomDto;
import com.locker.be.web.chat.service.ChatService;
import com.locker.be.web.user.util.JwtUserPrincipal;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("web/chat")
@RequiredArgsConstructor
public class ChatApi {

    private final ChatService chatService;

    @GetMapping("/rooms")
    public List<ChatRoomDto.RoomListItem> listRooms() {
        long userId = currentUserId();
        return chatService.listRoomsForUser(userId);
    }

    @PostMapping("/rooms")
    public ChatRoomDto.ChatRoom createOrGetRoom(@RequestBody ChatRoomDto.RoomInsertReq req) {
        long userId = currentUserId();
        return chatService.createOrGetRoom(userId, req);
    }

    @DeleteMapping("/rooms/{roomId}")
    public void exitRoom(@PathVariable long roomId) {
        long userId = currentUserId();
        chatService.exitRoom(roomId, userId);
    }

    @GetMapping("/rooms/{roomId}/messages")
    public List<ChatMessageDto.ChatMessage> listMessages(@PathVariable long roomId) {
        long userId = currentUserId();
        return chatService.listMessages(roomId, userId);
    }

    private long currentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof JwtUserPrincipal principal)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return principal.getUserId();
    }
}
