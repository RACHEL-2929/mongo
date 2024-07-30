package com.vam.service;

import java.util.List;

import com.vam.model.MessageVO;

public interface ChatService {

	public List<MessageVO> getList(MessageVO message);
	
}
