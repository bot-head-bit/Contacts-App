# Contacts-App

#### There are two components to this project ,Backend is built using Springboot ,MongoDB and Frontend using React.

------------



##### Prerequisites:
Bakend:
- Java 8
- Spring Boot 2.2.4 (with Spring Security, Spring Web, Spring Data MongoDB)
- jjwt 0.9.1
- MongoDB
- Maven 3.6.1

Frontend:

- React 16
- react-router-dom 5.1.2
- axios 0.19.2
- react-validation 3.0.7
- Bootstrap 4
- validator 12.2.0


------------

###### To run this appliaction  
Clone the repository

	   git clone git@github.com:bot-head-bit/Contacts-App.git 

### Note:

------------

Keep MongoDb ready and running on localhost 27017 
     
	   use contactdb
We also need to add some rows into roles collection before assigning any role to User.Run following MongoDB insert statements:
    
    db.roles.insertMany([
       { name: "ROLE_USER" },
       { name: "ROLE_MODERATOR" },
       { name: "ROLE_ADMIN" },
    ])
    

###### Now open the  ContactApp-backend folder and run the below command 
    
	mvn spring-boot:run

**Now the backend service will be running on your http://localhost:8082**

###### Now go to the  ContactApp-frontend folder 

#### Set port 

In the **.env** file 
    
	PORT=8081


In the current folder you can run 

    npm install
    # or
    yarn install

then 

    npm start
    # or
    yarn start

**Open http://localhost:8081 to view it in the browser.
**




