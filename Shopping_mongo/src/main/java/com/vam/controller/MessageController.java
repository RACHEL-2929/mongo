package com.vam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vam.model.MessageVO;
import com.vam.service.MessageService;




@RestController
@RequestMapping("/message")
public class MessageController {
	
	private final MessageService messageService;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping
    public MessageVO createMessage(@RequestBody MessageVO message) {
        return messageService.createMessage(message);
    }

    @GetMapping
    public List<MessageVO> getAllMessage() {
        return messageService.getAllMessage();
    }

    @GetMapping("/{id}")
    public MessageVO getMessageOne(@PathVariable String id) {
        return messageService.getMessageOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMessageById(@PathVariable String id) {
        messageService.deleteMessageById(id);
    }

}
