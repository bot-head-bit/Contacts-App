package com.contact.spring.jwt.mongodb.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contacts")
public class Contact {
	
	  @Id
	  private String id;

	  private String username;
	  
	  private String name;

	  private String email;

	  private String phone;
	  
	  public Contact() {
	  }

	  public Contact(String username, String name,String phone, String email) {
	    this.username = username;
	    this.email = email;
	    this.phone = phone;
	    this.name=name;
	  }
	  
	  public String getId() {
		    return id;
		  }

		  public void setId(String id) {
		    this.id = id;
		  }
		  
		  public String getUsername() {
			    return username;
			  }

			  public void setUsername(String username) {
			    this.username = username;
			  }

			  public String getEmail() {
			    return email;
			  }

			  public void setEmail(String email) {
			    this.email = email;
			  }

			  public String getPhone() {
			    return phone;
			  }

			  public void setPhone(String phone) {
			    this.phone = phone;
			  }
			  
			  public String getName() {
				    return name;
				  }

				  public void setName(String name) {
				    this.name = name;
				  }



}
