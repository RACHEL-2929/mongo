package com.syi.project.service.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syi.project.model.chat.ChatRoomVO;
import com.syi.project.model.enroll.EnrollVO;
import com.syi.project.model.syclass.SyclassVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

	private final ObjectMapper objectMapper;
    private Map<String,ChatRoomVO> chatRooms;
    
    @PostConstruct		//빈이 생성된 바로 실행되는 초기화 메소드에 사용
    private void init() {
    	chatRooms = new LinkedHashMap<String, ChatRoomVO>();
    }
    
    
    //채팅방 목록 조회
    @Override
    public List<ChatRoomVO> findAllChatRoom(){
    	return new ArrayList<>(chatRooms.values());
    }
    
    //채팅방 번호로 채팅방 찾기
	@Override
    public ChatRoomVO findChatRoomById(String chatRoomNo) {
    	return chatRooms.get(chatRoomNo);
    }
    
    //채팅방 개설
    @Override
    public ChatRoomVO createChatRoom(String chatRoomName) {
    	
    	//랜덤 아이디로 채팅방 번호 설정하기
    	String randomChatRoomNo = UUID.randomUUID().toString();
    	
    	//생성자를 사용해서 채팅방 번호와 채팅방 이름을 설정한 후 빌드 시킨다.
    	ChatRoomVO chatRoom = ChatRoomVO.builder()
    			.chatRoomNo(randomChatRoomNo)
    			.chatRoomName(chatRoomName)
    			.build();
    	//만들어진 ChatRoomVO 객체를 Map에다가 넣는다.
    	chatRooms.put(randomChatRoomNo, chatRoom);
    	return chatRoom;
    }
    
    //메시지 보내기
    @Override
	public <T> void sendMessage(WebSocketSession session, T message) {
    	
    	try {
    		//object 형태를 JSON 형태로 바꿔줘야 한다.->Jackson 라이브러리 사용함(Gson보다 기능이 좀 더 풍부함, Gson은 단순하고 빠른 작업)
    		session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
    	}catch (IOException e) {
    		log.error(e.getMessage(),e);
    	}
	}


	/*
	 * // 채팅방 목록 조회
	 * 
	 * @Override public List<ChatRoomVO> selectChatRoomList(int chatRoomMemberNo) {
	 * return chatRoomMapper.selectChatRoomList(chatRoomMemberNo); }
	 * 
	 * @Override public List<EnrollVO> selectEnrollListByMemberNo(int
	 * chatRoomMemberNo) { return
	 * chatRoomMapper.selectEnrollListByMemberNo(chatRoomMemberNo); }
	 * 
	 * @Override public SyclassVO selectClassByClassNo(int classNo) { return
	 * chatRoomMapper.selectClassByClassNo(classNo); }
	 * 
	 * @Override public int selectCountByMemberNoAndAdminNo(ChatRoomVO chatRoom) {
	 * return chatRoomMapper.selectCountByMemberNoAndAdminNo(chatRoom); }
	 * 
	 * // 채팅방 정보 넣기
	 * 
	 * @Override public int insertChatRoom(ChatRoomVO chatRoom) { return
	 * chatRoomMapper.insertChatRoom(chatRoom); }
	 */

	
	
	

}