package com.example.firstboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.firstboot.repository"
)
@EnableMongoRepositories(
        basePackages = "com.example.firstboot.mongorepo"
)
public class MultiDbConfig {

}
