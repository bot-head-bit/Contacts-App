package com.contact.spring.jwt.mongodb.dto;

import java.util.List;

import org.json.simple.JSONObject;

import com.contact.spring.jwt.mongodb.models.Contact;


public class ContactListingResponseDTO {

	
	private List<JSONObject> contactDetailsList1;

	public List<JSONObject> getContactDetailsList1() {
		return contactDetailsList1;
	}

	public void setContactDetailsList1(List<JSONObject> contactDetailsList1) {
		this.contactDetailsList1 = contactDetailsList1;
	}
}
