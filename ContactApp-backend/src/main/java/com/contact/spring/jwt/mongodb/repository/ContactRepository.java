package com.contact.spring.jwt.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.contact.spring.jwt.mongodb.models.Contact;


public interface ContactRepository extends MongoRepository<Contact, String> {
	  Optional<Contact> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	}