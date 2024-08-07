package com.syi.project.service.chat;

import java.util.List;

import org.springframework.web.socket.WebSocketSession;

import com.syi.project.model.chat.ChatRoomVO;

public interface ChatService {

	/*
	 * int insertChatRoom(ChatRoomVO chatRoom);
	 * 
	 * List<ChatRoomVO> selectChatRoomList(int chatRoomMemberNo);
	 * 
	 * List<EnrollVO> selectEnrollListByMemberNo(int chatRoomMemberNo);
	 * 
	 * SyclassVO selectClassByClassNo(int classNo);
	 * 
	 * int selectCountByMemberNoAndAdminNo(ChatRoomVO chatRoom);
	 */
	List<ChatRoomVO> findAllChatRoom();

	ChatRoomVO findChatRoomByNo(String chatRoomNo);

	ChatRoomVO createChatRoom(String chatRoomName);

	//<T> void sendMessage(WebSocketSession session, T message);

	
}