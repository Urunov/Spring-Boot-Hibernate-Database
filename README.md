
# Spring-DAO-ORM-JEE-Web-AOP-Core-Boot

![springMove](https://user-images.githubusercontent.com/11626327/82535853-7b9a8780-9b82-11ea-9d4d-bbda1711912f.jpg)

# 
## Spring Framework Architecure and Spring Framework Runtime 
![3 tier layer Jarsey   SpringBoot](https://user-images.githubusercontent.com/11626327/83234663-a2cd0680-a1cb-11ea-97b2-d268143cc972.jpg)
#


# SpringBoot-DAO-ORM-Web
More valuable information also here ([let's go](https://dev.to/urunov/how-to-handle-database-in-spring-boot-560))
1.  [Project-1. Spring Boot REST API JDBC MySQL Gradle](https://github.com/Hamdambek/SpringBoot-Database/tree/master/Project1-SpringBoot-RestAPI-JDBC-MySQL-Gradle)
     * Gradle project provides Spring Boot and JDBC (using Gradle)
2. [Project-2. Spring Boot REST API JDBC MySQL Maven](https://github.com/Hamdambek/SpringBoot-Database/tree/master/Project2-SpringBoot-RestAPI-JDBC%20Template-MySQL-Maven/SpringJDBC)
     * Family Member small project provides Spring Boot and JDBC template (using MySQL) implementation. In case of, Spring Boot using Maven configuration, and DB (database) using JDBC (only template not JPA ). 
3.  [Project-1. Spring Boot REST API JDBC MySQL Gradle](https://github.com/Hamdambek/SpringBoot-Database/tree/master/Project1-SpringBoot-RestAPI-JDBC-MySQL-Gradle)
     * Gradle project provides Spring Boot and JDBC (using Gradle)
4. [Project-4. SpringBoot-ToDo-Project](https://github.com/Urunov/Spring-DAO-ORM-JEE-Web-AOP-Core-Boot/tree/master/Project4-SpringBoot-ToDo-Project)
     * Todo project provides Spring Boot and JDBC template (using MySQL) implementation. In case of, Spring Boot using Maven configuration, and DB (database) using JDBC (only template not JPA ).
     * The mainly 2 parameters: Adding todo list of the daily, List all of DB todo lists.
 
5.  [Project-5.SpringBoot-UploadFiles and Image](https://github.com/Urunov/Spring-DAO-ORM-JEE-Web-AOP-Core-Boot/tree/master/Project5-SpringBoot-UploadFiles%20and%20Image)
     * Spring Boot + Thyeamleaf + Web : Project which uploading files existing source code (upload) folder.
          
6. [Project6 - Spring Boot Upload and Downloading File MySQLDB](https://github.com/Urunov/Spring-DAO-ORM-JEE-Web-AOP-Core-Boot/tree/master/Project6%20-%20Spring%20Boot%20Upload%20and%20Downloading%20File%20MySQLDB)
     * Spring Boot + Web + MySQL Thyeamleaf.
     * Uplad and Download files Store in DB (MySQL in example) 
     l      

# Core data for Spring Boot with Database 

This provides Database implementation in the Spring Boot. Indeed, We should breifly inform here concept of Spring, Spring Boot, JDBC, JPA, H2.

Spring
* The Spring Framework is an application framework and inversion of control container for the Java platform. Spring is HA (high avilability).

Spring Boot
* Most Spring Boot applications need minimal Spring configuration. Features. Create stand-alone Spring applications

JPA
* JPA (The Java Presistence API) = This module deals with enhanced support for JPA based data access layers.Indeed, the JPA is set of the rules to  interfaces. JPA follows Object-Relation Mapping (ORM). It is a set of interfaces. It also provides a runtime EntityManager API for processing queries and transactions on the objects against the database. It uses a platform-independent object-oriented query language JPQL (Java Persistent Query Language).

Why should we use JPA?
JPA is simpler, cleaner, and less labor-intensive than JDBC, SQL, and hand-written mapping. JPA is suitable for non-performance oriented complex applications.

API (Application programming interface) is a document that contains a description of all the features of a product or software. It represents classes and interfaces that software programs can follow to communicate with each other. An API can be created for applications, libraries, operating systems, etc.


JPA Implementations
JPA is an open-source API. There is various enterprises vendor such as Eclipse, RedHat, Oracle, etc. that provides new products by adding the JPA in them. There are some popular JPA implementations frameworks such as Hibernate, EclipseLink, DataNucleus, etc. It is also known as Object-Relation Mapping (ORM) tool.

JDBC
* Java Database Connectivity (JDBC) is an application programming interface (API) for the programming language Java, which defines how a client may access a database.
##
Architecute of the Project Implementation

![JDBC JPA](https://user-images.githubusercontent.com/11626327/76680830-9b1bae00-662f-11ea-84e8-941623ed7283.JPG)

##
H2
* H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode.
 
 ![H2 DB](https://user-images.githubusercontent.com/11626327/76680851-d61de180-662f-11ea-80c8-3a49632ff246.JPG)
## Regference

1. https://github.com/RameshMF/Hibernate-ORM-Tutorials
2. https://data-flair.training/blogs/spring-jdbc/
