package com.locker.be.web.chat.config;

import com.locker.be.web.user.util.JwtUserPrincipal;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StompAuthChannelInterceptor implements ChannelInterceptor {

    // HTTP 인증 필터에서 사용하는 JwtUtil을 재사용해 STOMP CONNECT 토큰을 검증한다.
    private final JwtUtil jwtUtil;

    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        // STOMP 프레임 메타데이터 접근 객체
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        // CONNECT 프레임에서만 인증 수행하고, 나머지 프레임은 그대로 통과시킨다.
        // (SUBSCRIBE/SEND 등은 CONNECT 시 설정된 Principal을 사용)
        if (accessor == null || !StompCommand.CONNECT.equals(accessor.getCommand())) {
            return message;
        }

        // 프론트에서 connectHeaders.Authorization 으로 전달한 JWT 헤더 추출
        List<String> authHeaders = accessor.getNativeHeader("Authorization");
        List<String> safeHeaders = authHeaders == null ? List.of() : authHeaders;
        if (CollectionUtils.isEmpty(safeHeaders)) {
            throw new AccessDeniedException("Missing Authorization header on STOMP CONNECT");
        }

        // "Bearer xxx" 형식/원시 토큰 형식 모두 허용
        String raw = safeHeaders.stream()
                .filter(header -> header != null && !header.isBlank())
                .findFirst()
                .orElseThrow(() -> new AccessDeniedException("Invalid Authorization header"));
        String token = raw.startsWith(BEARER_PREFIX) ? raw.substring(BEARER_PREFIX.length()) : raw;

        // 토큰 형식/만료/서명 검증 실패 시 CONNECT 자체를 거부한다.
        if (token.isBlank() || !jwtUtil.validateToken(token)) {
            throw new AccessDeniedException("Invalid or expired token");
        }

        // 인증 성공 시 STOMP 세션 Principal을 주입한다.
        // 이후 @MessageMapping 의 Principal 파라미터에서 userId 식별 가능.
        Long userId = jwtUtil.getUserId(token);
        accessor.setUser(new JwtUserPrincipal(userId));
        return message;
    }
}
