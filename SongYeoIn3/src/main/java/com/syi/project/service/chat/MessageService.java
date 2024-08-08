package com.syi.project.service.chat;

import java.util.List;

import com.syi.project.model.chat.MessageDTO;

public interface MessageService {
	
	public MessageDTO createMessage(MessageDTO message);
	public List<MessageDTO> getAllMessage();
	public MessageDTO getMessageOne(String id);
	public void deleteMessageById(String id);
	
	

}
