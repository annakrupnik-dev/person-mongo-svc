package com.example.person.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
@PropertySources({ @PropertySource("classpath:mongodb/mongodb.${mongoEnvironment:{environment}}.properties") })
@Slf4j
public class MongoDbConfig extends AbstractMongoClientConfiguration {

    @Autowired
    Environment environment;

    protected String getDatabaseName() {
        return environment.getProperty("spring.data.mongodb.database");
    }

    @Override
    public MongoClient mongoClient() {
        log.info("Initializing MongoDB...");
        String mongoClientURI = environment.getProperty("spring.data.mongodb.uri");
        if (mongoClientURI!=null) {
            log.info("mongoClientURI loaded successfully! ");
        }
        return MongoClients.create(mongoClientURI);
    }

}
