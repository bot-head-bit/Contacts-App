package com.contact.spring.jwt.mongodb.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.contact.spring.jwt.mongodb.dto.ContactListingDTO;
import com.contact.spring.jwt.mongodb.dto.ContactListingResponseDTO;
import com.contact.spring.jwt.mongodb.dto.ContactRequestDTO;
import com.contact.spring.jwt.mongodb.models.Contact;
import com.contact.spring.jwt.mongodb.repository.ContactRepository;
import com.contact.spring.jwt.mongodb.security.services.ContactService;
import com.contact.spring.jwt.mongodb.utils.MongodbConnector;




@Service("ContactService")
@Component
public class ContactServiceImpl implements ContactService  {
	
	@Autowired
	ContactRepository contRepo;
	
	@Autowired
	private MongodbConnector connectToDb;


	
	
	

	@Override
	public String ContactsApi(ContactRequestDTO contact) {
		
		Contact c = new Contact();
		
		c.setUsername(contact.getUsername());
		c.setName(contact.getName());
		c.setEmail(contact.getEmail());
		c.setPhone(contact.getPhone());
		contRepo.save(c);
		return "Siuuuuuuuuuuuuuuuuuuuuuu";
		
		
		
		
	}

	@Override
	public ContactListingResponseDTO ContactListingApi(ContactListingDTO contactListingDTO) {
		ContactListingResponseDTO contactDetailsList = new ContactListingResponseDTO();
		contactDetailsList = connectToDb.pagination(contactListingDTO);
		return contactDetailsList;
	}
	
}
