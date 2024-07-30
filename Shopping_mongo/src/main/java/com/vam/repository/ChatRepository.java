package com.vam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.vam.model.MessageVO;

@EnableMongoRepositories
public interface ChatRepository extends MongoRepository<MessageVO, String>{

}
