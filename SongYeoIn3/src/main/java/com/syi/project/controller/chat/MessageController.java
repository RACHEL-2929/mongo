package com.syi.project.controller.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.syi.project.model.chat.MessageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MessageController {
	
	
	@MessageMapping("/chat.sendMessage")
    @SendTo("/sub/public")
    public MessageDTO sendMessage(@Payload MessageDTO chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/sub/public")
    public MessageDTO addUser(@Payload MessageDTO chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
	
	
	
	

	/*
	 * private final SimpMessageSendingOperations template; private final
	 * ChatService chatService;
	 * 
	 * @MessageMapping("/enterUser") public void enterUser(@Payload MessageDTO
	 * message, SimpMessageHeaderAccessor headerAccessor) { //
	 * chatService.plusUserCnt(message.getChatRoomNo()); String userUUID =
	 * chatService.addUser(message.getChatRoomNo(), message.getSender());
	 * log.info(userUUID);
	 * 
	 * headerAccessor.getSessionAttributes().put("userUUID", userUUID);
	 * headerAccessor.getSessionAttributes().put("chatRoomNo",
	 * message.getChatRoomNo());
	 * 
	 * message.setMessage(message.getSender() + " 님 입장");
	 * template.convertAndSend("/sub/chat/room/" + message.getChatRoomNo(),
	 * message);
	 * 
	 * }
	 * 
	 * @MessageMapping("/sendMessage") public void sendMessage(@Payload MessageDTO
	 * message) { log.info("CHAT {}", message);
	 * message.setMessage(message.getMessage());
	 * template.convertAndSend("/sub/chat/room/" + message.getChatRoomNo(),
	 * message); }
	 */

	/*
	 * 
	 * 
	 * 
	 * 
	 * public MessageController(MessageService messageService) { this.messageService
	 * = messageService; }
	 * 
	 * @PostMapping public MessageDTO createMessage(@RequestBody MessageDTO message)
	 * { return messageService.createMessage(message); }
	 * 
	 * @GetMapping public List<MessageDTO> getAllMessage() { return
	 * messageService.getAllMessage(); }
	 * 
	 * @GetMapping("/{id}") public MessageDTO getMessageOne(@PathVariable String id)
	 * { return messageService.getMessageOne(id); }
	 * 
	 * @DeleteMapping("/{id}") public void deleteMessageById(@PathVariable String
	 * id) { messageService.deleteMessageById(id); }
	 */
}
