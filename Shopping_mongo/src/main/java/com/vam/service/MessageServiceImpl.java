package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.model.MessageVO;
import com.vam.repository.ChatRepository;

@Service
public class MessageServiceImpl implements MessageService{
	
	private final ChatRepository chatRepository;
	
	@Autowired
	private MessageServiceImpl(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
	}

	@Override
	public MessageVO createMessage(MessageVO message) {
		return chatRepository.insert(message);
	}

	@Override
	public List<MessageVO> getAllMessage() {
		return chatRepository.findAll();
	}

	@Override
	public MessageVO getMessageOne(String id) {
		return chatRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteMessageById(String id) {
		chatRepository.deleteById(id);
	}

}
