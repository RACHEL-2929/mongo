package com.vam.mapper;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vam.model.MessageVO;

public interface ChatRepository extends MongoRepository<MessageVO, String>{

}
