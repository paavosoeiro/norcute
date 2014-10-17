package br.com.tinysoft.social.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@EnableMongoRepositories
@Configuration
@ComponentScan(basePackages = { "br.com.tinysoft.social.persistence" })
public class PersistenceConfig extends AbstractMongoConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return "local";
	}

	@Override
	protected String getMappingBasePackage() {
		return "br.com.tinysoft.social.persistence";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClient mongo = new MongoClient();
		return mongo;
	}
}
