package com.syi.project.model.chat;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "messages")
@Data
public class MessageDTO {

	@Id
	private String id;
	
	private String roomId;
	
	@Field(name = "message")	//content
	private String message;
	
	private String sender;//메시지 보낸 사람
	
	
	/*
	 * @Field(name="timestamp") private Date timeStamp;
	 */
	
	@Field(name="type")
	private MessageType type;
	
	public enum MessageType{
		ENTER, TALK
	}
	
	/*
	 * public enum MessageType{
	 * ENTER, TALK
	 * }
	 * 
	 * private MessaageType type;
	 * private String roomId;
	 * private String sender;
	 * private String message;
	 * 
	 * 
	 * */
	
	
}
