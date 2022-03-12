package com.contact.spring.jwt.mongodb.dto;

public class ContactRequestDTO {

	private String username;
	private String name;
	private String email;
	private String phone;
	public void setUsername(String username) {
	    this.username= username;
	  }
    public String getUsername() {
	    return username;
	  } 
    public void setName(String name) {
	    this.name= name;
	  }
    public String getName() {
	    return name;
	  } 
    public void setEmail(String email) {
	    this.email= email;
	  }
    public String getEmail() {
	    return email;
	  } 
    public void setPhone(String phone) {
	    this.phone= phone;
	  }
    public String getPhone() {
	    return phone;
	  } 


}
