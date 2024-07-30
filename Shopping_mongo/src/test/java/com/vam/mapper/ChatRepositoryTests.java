package com.vam.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.MessageVO;
import com.vam.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ChatRepositoryTests {
	
	@Autowired
	private MessageService messageService;
	

	
	@Test
	public void createMessage() {
		MessageVO message = new MessageVO();
		
		message.setMessageNo("1");
		message.setContent("메시지 전달내용을 적었습니다.");
		message.setTimeStamp(new Date());
		message.setType("text");
		
		
		messageService.createMessage(message);
	}

}