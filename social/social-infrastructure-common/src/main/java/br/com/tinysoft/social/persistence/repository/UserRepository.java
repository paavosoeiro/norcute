package br.com.tinysoft.social.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.tinysoft.social.persistence.User;

@Repository
public class UserRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void insert(User user) {
		mongoTemplate.save(user);
	}
}
