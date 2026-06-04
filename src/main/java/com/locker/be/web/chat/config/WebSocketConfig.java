package com.locker.be.web.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // STOMP CONNECT 프레임 수신 시 JWT를 검증하는 인바운드 인터셉터
    private final StompAuthChannelInterceptor stompAuthChannelInterceptor;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 서버 -> 클라이언트 브로드캐스트용 prefix
        // 예: /topic/web/chat.{roomId}
        config.enableSimpleBroker("/topic/web");

        // 클라이언트 -> 서버 전송용 prefix
        // 예: /app/web/chat/{roomId}/send (@MessageMapping 과 매핑)
        config.setApplicationDestinationPrefixes("/app/web");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket 최초 핸드셰이크 엔드포인트
        // 프론트는 SockJS를 사용하므로 withSockJS()를 활성화한다.
        // CORS는 개발 환경 FE 주소만 허용한다.
        registry.addEndpoint("/ws/web/chat")
                .setAllowedOriginPatterns("http://localhost:5173", "http://127.0.0.1:5173", "https://loocker.site")
                .withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        // 클라이언트에서 서버로 들어오는 STOMP 프레임에 인터셉터 적용
        // CONNECT 시 인증 완료 후 accessor.setUser(...)로 Principal이 설정되며,
        // 이후 @MessageMapping 메서드에서 Principal로 sender 식별이 가능해진다.
        registration.interceptors(stompAuthChannelInterceptor);
    }
}
