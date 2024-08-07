package com.syi.project.service.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syi.project.mapper.chat.MessageRepository;
import com.syi.project.model.chat.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {

	
	private final MessageRepository messageRepository;

	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public MessageDTO createMessage(MessageDTO message) {
		return messageRepository.insert(message);
	}

	@Override
	public List<MessageDTO> getAllMessage() {
		return messageRepository.findAll();
	}

	@Override
	public MessageDTO getMessageOne(String id) {
		return messageRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteMessageById(String id) {
		messageRepository.deleteById(id);
	}

}
