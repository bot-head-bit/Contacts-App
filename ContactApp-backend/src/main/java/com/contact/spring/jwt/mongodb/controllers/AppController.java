package com.contact.spring.jwt.mongodb.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contact.spring.jwt.mongodb.dto.BaseResponse;
import com.contact.spring.jwt.mongodb.dto.ContactListingDTO;
import com.contact.spring.jwt.mongodb.dto.ContactListingResponseDTO;
import com.contact.spring.jwt.mongodb.dto.ContactRequestDTO;
import com.contact.spring.jwt.mongodb.security.services.ContactService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/contact")
public class AppController {
	
	
	/** The message source. */
	@Autowired
	MessageSource messageSource;
	

	
	/** The video service. */
	@Qualifier("ContactService")
	@Autowired
	private ContactService contactService;
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addContactsAPI(@RequestBody ContactRequestDTO contactDTO)
	{
		LOGGER.info("Add contacts API...");
		try
		{
			String contactResponse = contactService.ContactsApi(contactDTO);
			if (contactResponse != null)
			{
				return new ResponseEntity<Object>(
						new BaseResponse(HttpStatus.OK.value(),
								messageSource.getMessage("contact.success", null, null), contactResponse),
						HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>(
						new BaseResponse(HttpStatus.NO_CONTENT.value(),
								messageSource.getMessage("contact.nocontent", null, null)),
						HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage());
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.NO_CONTENT.value(),
					messageSource.getMessage("contact.nocontent", null, null)), HttpStatus.NO_CONTENT);
		}
	} 
	
	@RequestMapping(value = "/listing", method = RequestMethod.POST)
	public ResponseEntity<?> contactApi(@RequestBody ContactListingDTO contactListingDTO)
	{
		LOGGER.info("Inside Contact listing api...");
		try
		{
			ContactListingResponseDTO response = contactService.ContactListingApi(contactListingDTO);
			if (response != null)
			{
				return new ResponseEntity<Object>(
						new BaseResponse(HttpStatus.OK.value(),
								messageSource.getMessage("listing.success", null, null), response),
						HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>(
						new BaseResponse(HttpStatus.NO_CONTENT.value(),
								messageSource.getMessage("listing.nocontent", null, null)),
						HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage());
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.NO_CONTENT.value(),
					messageSource.getMessage("listing.nocontent", null, null)), HttpStatus.NO_CONTENT);
		}
	} 
	

}
