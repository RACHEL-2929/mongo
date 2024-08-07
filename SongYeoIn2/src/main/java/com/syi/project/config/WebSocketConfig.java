package com.syi.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	//STOMP 메시지 매핑
	
	/*
	 * STOMP 방식을 적용하려고 함
	 * 클라이언트가 특정 주소를 구독할 수 있고, 메시지를 보내면 메시지 브로커가 해당 주소를 구독하는 모든 클라이언트들에게 
	 * 메시지를 보여주는 방식
	 * 
	 * 
	 * 
	 * */
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                //클라이언트가 websocket handshake로 커넥션할 경로
                .setAllowedOrigins("*");//http://localhost:8080
                //가능한 경로 설정 ( 전체 오픈 : 기호에따라 수정 )
                //.withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/pub");
        // /pub 으로 시작하는 stomp 메세지의 경로는 @controller @MessageMaping 메서드로 라우팅
        config.enableSimpleBroker("/sub");
        // /sub 로 시작하는 stomp 메세지는 브로커로 라우팅함
    }
	
	/*
	 * @Override public void configureMessageBroker(MessageBrokerRegistry config) {
	 * 
	 * //메시지 구독 url (topic을 구독) config.enableSimpleBroker("/sub");
	 * 
	 * //메시지 발행 url config.setApplicationDestinationPrefixes("/pub");
	 * 
	 * }
	 * 
	 * @Override public void registerStompEndpoints(StompEndpointRegistry registry)
	 * { registry.addEndpoint("/ws") .setAllowedOriginPatterns("*"); }
	 */
	

	

}
