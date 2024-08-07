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
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	/*
	 * STOMP 방식을 적용하려고 함
	 * 클라이언트가 특정 주소를 구독할 수 있고, 메시지를 보내면 메시지 브로커가 해당 주소를 구독하는 모든 클라이언트들에게 
	 * 메시지를 보여주는 방식
	 * 
	 * */
	
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		
		//메시지 구독 url (topic을 구독)
		config.enableSimpleBroker("/sub");

		//메시지 발행 url
		config.setApplicationDestinationPrefixes("/pub");
		
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
		.setAllowedOriginPatterns("*");
	}
	
	

	

}
