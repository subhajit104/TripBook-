## SpringBoot Project: TripBook 
       This is a sample Java / Maven / Spring Boot (version 2.3.3) application that can be used as a starter 
       for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.
### How to run: 
       This application is packaged as a jar which has Tomcate mbedded. No Tomcat or JBoss installation is necessary.
       You run it using the java -jar command.
       Clone this repository
       Make sure you are using Java 14 and Maven 4
       You can build the project and run the tests by running mvn clean package
       Once successfully built, you can run the service using this method: " java -jar target/*.jar "  
### About the Service:
   The service is just a simple Trip review REST service. It uses an in-memory database (H2) to store the data.
   You can also do with a relational database like MySQL or PostgreSQL with a little modification at properties.
   If your database connection properties work, you can call some REST endpoints defined in package com.example.trip.business.controller on port 8080;
   You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service. 
   Here is what this little application demonstrates:
   
      Full integration with the latest Spring Framework: inversion of control, dependency injection, etc.
      Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the java -jar command
      Demonstrates how to set up healthcheck, metrics, info, environment, etc. endpoints automatically on a configured port. Inject your own health / metrics info with a few lines of code.
      Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired Accept header in your request
      Exception mapping from application exceptions to the right HTTP response with exception details in the body
      Spring Data Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
      Automatic CRUD functionality against the data source using Spring Repository pattern
### List Of Tours:

### End points: Post Ratings For A Trip.
     
### List Of Ratings For Tour:


### Update Rating For A Tour: 


### Delete Rating For A Tour Of A Customer: 


### List Of TourPackages: 


### To view your H2 in-memory database
   The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8080/h2-console.
   Default username is 'sa'
   with a blank password. Make sure you disable this in your production profiles. For more, see https://goo.gl/U8m62X
      
### Running Project With MySql or PostGreSql 

### Questions and Comments: subhajit.manna.104@gmail.com