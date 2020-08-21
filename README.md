# SpringBoot Project: TripBook 
This is a sample Java / Maven / Spring Boot (version 2.3.3) application that can be used as a starter 
for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.
### How to run: 
       1. This application is packaged as a jar which has Tomcate mbedded. No Tomcat or JBoss installation is necessary.
       2. You run it using the java -jar command.
       3. Clone this repository
       4. Make sure you are using Java 14 and Maven 4
       5. You can build the project and run the tests by running mvn clean package
       6. Once successfully built, you can run the service using this method: " java -jar target/*.jar "  
### About the Service:
   The service is just a simple Trip review REST service. It uses an in-memory database (H2) to store the data.
   
   You can also do with a relational database like MySQL or PostgreSQL with a little modification at properties.
   
   If your database connection properties work, you can call some REST endpoints defined in package com.example.trip.business.controller on port 8080;
   You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service. 
   Here is what this little application demonstrates:
   
      1. Full integration with the latest Spring Framework: inversion of control, dependency injection, etc.
      2. Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the java -jar command
      3. Demonstrates how to set up healthcheck, metrics, info, environment, etc. endpoints automatically on a configured port. Inject your own health / metrics info with a few lines of code.
      4. Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired Accept header in your request
      5. Exception mapping from application exceptions to the right HTTP response with exception details in the body
      6. Spring Data Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
      7. Automatic CRUD functionality against the data source using Spring Repository pattern
### End point: List Of Tours:
   GET http://localhost:8080/tours
### End point: Post Ratings For A Trip.
   POST http://localhost:8080/tours/1/hotels
   Accept: application/json
   Content-Type: application/json
   
       {
               "score":"5",
               "comment":"Enjoyed a lot",
               "customerId": "5"
        
       }
      
       RESPONSE: HTTP 201 (Created)
       {
           "pk": {
               "tour": {
                   "id": 1,
                   "title": "Big Sur Retreat",
                   "description": "The region know as Big Sur is like Yosemite's younger cousin, with all the redwood scaling, rock climbing and, best of all, hiking that the larger park has to offer. Robison Jeffers once said, \"Big Sur is the greatest meeting of land and sea in the world,\" but the highlights are only accessible on foot.\nOur 3-day tour allows you to choose from multiple hikes led by experienced guides during the day, while comfortably situated in the evenings at the historic Big Sur River Inn. Take a tranquil walk to the coastal waterfall at Julia Pfeiffer Burns State Par or hike to the Married Redwoods. If you're prepared for a more strenuous climb, try Ollason's Peak in Toro Park. An optional 4th day includes admission to the Henry Miller Library and the Point Reyes Lighthouse.",
                   "blurb": "Big Sur is big country. The Big Sur Retreat takes you to the most majestic part of the Pacific Coast and show you the secret trails.",
                   "price": 750,
                   "duration": "3 days",
                   "bullets": "Accommodations at the historic Big Sur River Inn, Privately guided hikes through any of the 5 surrounding national parks, Picnic lunches prepared by the River Inn kitchen, Complimentary country breakfast, Admission to the Henry Miller Library and the Point Reyes Lighthouse",
                   "keywords": "Hiking, National Parks, Big Sur",
                   "tourPackage": {
                       "code": "BC",
                       "name": "Backpack Cal"
                   },
                   "difficulty": "Medium",
                   "region": "Central_Coast"
               },
               "customerId": 48
           },
           "score": 5,
           "comment": "This was really awsome"
       }
    
### End point: List Of Ratings For Tour:
   GET http://localhost:8080/tours/1/ratings/average <br />
   RESPONSE: HTTP 200 (OK) <br />
   
       {
           "tourTitle": "Big Sur Retreat",
           "tourDescription": "The region know as Big Sur is like Yosemite's younger cousin, with all the redwood scaling, rock climbing and, best of all, hiking that the larger park has to offer. Robison Jeffers once said, \"Big Sur is the greatest meeting of land and sea in the world,\" but the highlights are only accessible on foot.\nOur 3-day tour allows you to choose from multiple hikes led by experienced guides during the day, while comfortably situated in the evenings at the historic Big Sur River Inn. Take a tranquil walk to the coastal waterfall at Julia Pfeiffer Burns State Par or hike to the Married Redwoods. If you're prepared for a more strenuous climb, try Ollason's Peak in Toro Park. An optional 4th day includes admission to the Henry Miller Library and the Point Reyes Lighthouse.",
           "averageRating": 5,
           "comments": [
               "This was really awsome"
           ]
       }

### End point: Delete Rating For A Tour Of A Customer: 
   DELETE http://localhost:8080/tours/1/ratings/48   ( 48 is the customerID)
   Accept: application/json
   
       Content-Type: application/json
       {
               "score":"5",
               "comment":"This was really awsome",
               "customerId": "48"
       }
       
### To view your H2 in-memory database
   The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8080/h2-console.<br />
   Default username is 'sa'. <br />
   with a blank password. Make sure you disable this in your production profiles. For more, see https://goo.gl/U8m62X <br />
      
### Running Project With MySql or PostGreSql: 
   This project uses an in-memory database so that you don't have to install a database in order to run it. <br />
   However, converting it to run with another relational database such as MySQL or PostgreSQL is very easy. <br />
   Since the project uses Spring Data and the Repository pattern, it's even fairly easy to back the same service with MongoDB. <br />
    
   Here is what you would do to back the services with MySQL, for example: <br />
   In pom.xml add: 
      
                           <dependency>
                           <groupId>org.postgresql</groupId>
                           <artifactId>postgresql</artifactId>
                           </dependency>
   
   Append this to the end of application.properties: 
    
      
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.hibernate.show-sql=true
    spring.datasource.url=jdbc:postgresql:<your_mysql_host_or_ip>/postgres
    spring.datasource.username=<UserName> 
    spring.datasource.password=<PassWord> 
             

### Questions and Comments: subhajit.manna.104@gmail.com