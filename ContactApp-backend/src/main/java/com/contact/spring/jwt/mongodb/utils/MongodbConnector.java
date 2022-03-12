package com.contact.spring.jwt.mongodb.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Filters.*;
import com.contact.spring.jwt.mongodb.dto.ContactListingDTO;
import com.contact.spring.jwt.mongodb.dto.ContactListingResponseDTO;
import com.contact.spring.jwt.mongodb.models.Contact;
import com.contact.spring.jwt.mongodb.security.services.MessageConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;


@Component
public class MongodbConnector {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MongodbConnector.class);
	
	private @Autowired MongoClient mClient;
	
	public ContactListingResponseDTO pagination(ContactListingDTO contactListingDTO) {
		ContactListingResponseDTO contactListingResponseDTO = new ContactListingResponseDTO();
		
		try {
			//MongoClient mongoClient = getMongoClient();
			MongoDatabase mongoDB = mClient.getDatabase("authdb");
			MongoCollection<Document> auditCollection = mongoDB.getCollection("contacts");
			Document regQuery = new Document();
			regQuery.append("$eq",contactListingDTO.getUsername());
			System.out.println(contactListingDTO.getUsername());
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("username", regQuery);
			FindIterable<Document> findIterable = auditCollection.find(new Document(whereQuery));
			Iterator<Document> iterator = findIterable.iterator();
			int documentCount = 0;
			
			while (iterator.hasNext()) {
				iterator.next();
				documentCount++;
			}
			System.out.println(documentCount);
			
			//Bson filter = Filters.e
		     List<JSONObject> contactDetailsList = new Vector<JSONObject>();
			/*(MongoCursor<Document> cursor = auditCollection.find(whereQuery).iterator();
			while (cursor.hasNext()) {
				
				String jsonvalue = cursor.next().toJson();
				System.out.println(jsonvalue);
				JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonvalue);
				contactDetailsList.add(jsonObject);
			} */
		    Bson projection = fields(include("name", "phone","email"), excludeId());
		    FindIterable<Document> cursor = auditCollection.find(new Document(whereQuery)).projection(projection);
			cursor.forEach((Document document)  -> {
				try {
					contactDetailsList.add((JSONObject) new JSONParser().parse(document.toJson()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			contactListingResponseDTO.setContactDetailsList1(contactDetailsList);
			return contactListingResponseDTO;
		} catch (Exception e) {
			
			LOGGER.error(MessageConstants.EXCEPTION, e);
			return contactListingResponseDTO;
		}

	}

		
	
}
