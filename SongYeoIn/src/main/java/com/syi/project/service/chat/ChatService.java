package com.syi.project.service.chat;

import java.util.List;

import org.springframework.web.socket.WebSocketSession;

import com.syi.project.model.chat.ChatRoomVO;
import com.syi.project.model.enroll.EnrollVO;
import com.syi.project.model.syclass.SyclassVO;

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

	<T> void sendMessage(WebSocketSession session, T message);

	ChatRoomVO createChatRoom(String chatRoomName);

	List<ChatRoomVO> findAllChatRoom();

	ChatRoomVO findChatRoomById(String chatRoomNo);
	
}