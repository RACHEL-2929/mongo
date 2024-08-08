package com.syi.project.mapper.chat;

import java.util.List;

import com.syi.project.model.chat.ChatRoomVO;
import com.syi.project.model.enroll.EnrollVO;
import com.syi.project.model.syclass.SyclassVO;

public interface ChatRoomMapper {


	List<ChatRoomVO> selectChatRoomList(int chatRoomMemberNo);

	List<EnrollVO> selectEnrollListByMemberNo(int chatRoomMemberNo);

	SyclassVO selectClassByClassNo(int classNo);

	int selectCountByMemberNoAndAdminNo(ChatRoomVO chatRoom);

	int insertChatRoom(ChatRoomVO chatRoom);
	
	
}