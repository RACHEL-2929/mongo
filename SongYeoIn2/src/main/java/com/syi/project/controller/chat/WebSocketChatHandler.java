package com.syi.project.controller.chat;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syi.project.model.chat.ChatRoomVO;
import com.syi.project.model.chat.MessageDTO;
import com.syi.project.service.chat.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {

	// 스프링 지원 소켓 핸들링 방식에는 텍스트와 바이너리 방식이 있음
	// TextWebSocketHandler, BinaryWebSocketHandler
	// 채팅이므로 텍스트 방식 상속 받기

	/*
	 * private final ObjectMapper objectMapper; private final ChatService
	 * chatService;
	 */
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("payload {}",payload);
		
		/*
		 * //JSON 형태를 messageDTO 형식에 맞게 매핑시켜서 저장해준다. MessageDTO messageDTO =
		 * objectMapper.readValue(payload, MessageDTO.class); ChatRoomVO chatRoom =
		 * chatService.findChatRoomByNo(messageDTO.getChatRoomNo());
		 * chatRoom.handleActions(session, messageDTO, chatService);
		 */
	}

}
