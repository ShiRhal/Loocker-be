package com.locker.be.chat.api;

import com.locker.be.chat.dto.ChatMessageDto;
import com.locker.be.chat.service.ChatService;
import com.locker.be.user.util.JwtUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ChatStompController {

    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{roomId}/send")
    public void send(
            @DestinationVariable long roomId,
            @Payload ChatMessageDto.SendReq body,
            Principal principal
    ) {
        if (!(principal instanceof JwtUserPrincipal jwtPrincipal)) {
            throw new AccessDeniedException("Unauthorized");
        }
        Long senderId = jwtPrincipal.getUserId();
        ChatMessageDto.ChatMessage saved = chatService.saveAndBuildMessage(roomId, senderId, body != null ? body.getMESSAGE() : null);
        messagingTemplate.convertAndSend("/topic/chat." + roomId, saved);
    }
}
