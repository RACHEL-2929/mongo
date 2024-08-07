package com.syi.project.model.chat;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import com.syi.project.service.chat.ChatService;

import lombok.Builder;
import lombok.Data;

@Data
public class ChatRoomVO {
	//채팅방 넘버
	private String chatRoomNo;
	
	private String chatRoomName;
	
	public ChatRoomVO create(String chatRoomName) {
		ChatRoomVO chatRoom = new ChatRoomVO();
		chatRoom.chatRoomNo = UUID.randomUUID().toString();
		chatRoom.chatRoomName = chatRoomName;
		
		return chatRoom;
	}
	
	/*=> 더 이상 세션을 관리할 필요가 없다(STOMP)=> 메시지 브로커가 주고 받는 곳의(주소) 정보를 가지고 있으니까*/
	
	
	//누구와 누구의 대화방인지
	/*
	 * private Set<WebSocketSession> chatRoomSessions = new HashSet<>();
	 * 
	 * 
	 * @Builder public ChatRoomVO(String chatRoomNo, String chatRoomName) {
	 * this.chatRoomNo = chatRoomNo; this.chatRoomName = chatRoomName; }
	 */
	
	
	/*
	 * //누가 들어왔나(session), 어떤 메세지 정보를 가졌나(message), 어떻게 처리할건가(chatService) public
	 * void handleActions(WebSocketSession session, MessageDTO message, ChatService
	 * chatService) {
	 * 
	 * if(message.getType().equals(MessageDTO.MessageType.ENTER)) {
	 * chatRoomSessions.add(session); message.setMessage(message.getSender() +
	 * "님이 입장했습니다."); }
	 * 
	 * sendMessage(message, chatService); }
	 * 
	 * 
	 * private <T> void sendMessage(T message, ChatService chatService) {
	 * chatRoomSessions.parallelStream() .forEach(session->
	 * chatService.sendMessage(session,message)); }
	 */
	
	
	
	/*
	 * //채팅방에 속해 있는 멤버 넘버 private int chatRoomMemberNo;
	 * 
	 * //채팅방에 속해 있는 담당자 넘버 private int chatRoomAdminNo;
	 * 
	 * private MemberVO member;
	 */
	
	/*
	 * private roomId;
	 * private name;
	 * private Set<WebSocketSession> sessions = new HashSet<>();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
}