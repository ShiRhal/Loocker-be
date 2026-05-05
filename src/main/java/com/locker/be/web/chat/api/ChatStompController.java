package com.locker.be.web.chat.api;

import com.locker.be.web.chat.dto.ChatMessageDto;
import com.locker.be.web.chat.service.ChatService;
import com.locker.be.web.user.util.JwtUserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Slf4j
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
        log.info("[STOMP] /app/web/chat/{}/send received, principal={}, body={}",
                roomId, principal, body);
        if (!(principal instanceof JwtUserPrincipal jwtPrincipal)) {
            throw new AccessDeniedException("Unauthorized");
        }
        Long senderId = jwtPrincipal.getUserId();
        try {
            ChatMessageDto.ChatMessage saved = chatService.saveAndBuildMessage(
                    roomId, senderId, body != null ? body.getMESSAGE() : null);
            log.info("[STOMP] saved chat message id={}, roomId={}, senderId={}",
                    saved.getCHAT_MESSAGE_ID(), roomId, senderId);
            messagingTemplate.convertAndSend("/topic/web/chat." + roomId, saved);
        } catch (Exception e) {
            log.error("[STOMP] failed to save/send chat message roomId={}, senderId={}",
                    roomId, senderId, e);
            throw e;
        }
    }
}
