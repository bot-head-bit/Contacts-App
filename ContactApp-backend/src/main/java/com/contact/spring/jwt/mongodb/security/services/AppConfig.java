package com.contact.spring.jwt.mongodb.security.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;



@Configuration
public class AppConfig {

  /*
   * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
   */
   public @Bean MongoClient mongoClient() {
       return MongoClients.create("mongodb://localhost:27017/contactdb?authSource=admin");
   }
}