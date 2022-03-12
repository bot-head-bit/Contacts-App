package com.contact.spring.jwt.mongodb.security.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.contact.spring.jwt.mongodb.dto.ContactListingDTO;
import com.contact.spring.jwt.mongodb.dto.ContactListingResponseDTO;
import com.contact.spring.jwt.mongodb.dto.ContactRequestDTO;


public interface ContactService
{
	
	
   String ContactsApi(ContactRequestDTO contactRequestDTO);
   
   ContactListingResponseDTO ContactListingApi(ContactListingDTO contactListingDTO);

	
}
