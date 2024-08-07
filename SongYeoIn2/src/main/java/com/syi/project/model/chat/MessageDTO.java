package com.syi.project.model.chat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "messages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	public enum MessageType{
		ENTER, TALK, LEAVE;
	}
	
	@Field(name="type")
	private MessageType type;
	
	private String chatRoomNo;
	
	private String sender;//메시지 보낸 사람
	
	@Field(name = "message")	//content
	private String message;
	
	@Field(name="timestamp")
	private String time; //채팅 발송 시간
	
	
	/*
	 * @Id private String id;
	 */
	
	/*
	 * @Field(name="timestamp") private Date timeStamp;
	 */
	
	
	
	
}
