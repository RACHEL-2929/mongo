package com.syi.project.service.chat;

import java.util.ArrayList;
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

	String addUser(String chatRoomNo, String sender);
	
	String getUserName(String chatRoomNo, String userUUID);
	
	ArrayList<String> getUserList(String chatRoomNo);

	//void plusUserCnt(String chatRoomNo);

	//<T> void sendMessage(WebSocketSession session, T message);

	
}