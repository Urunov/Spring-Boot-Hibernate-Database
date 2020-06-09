

     * Todo project provides Spring Boot and JDBC template (using MySQL) implementation. 
     In case of, Spring Boot using Maven configuration, and DB (database) using JDBC (only template not JPA ).
     * The mainly 2 parameters: Adding todo list of the daily, List all of DB todo lists.

Figure-1. Spring MyScheduler total db informations.
![SpringDBInterconnect](https://user-images.githubusercontent.com/11626327/84129040-611a4680-aa7c-11ea-9d2c-288c3c6b6675.JPG)

Important: 

  <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.0.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
  
  <groupId>spring</groupId>
    <artifactId>todo</artifactId>
    <version>0.0.1</version>
    <name>todo</name>
    <description>Demo project for Spring Boot</description>

   | <properties>
   |     <java.version>11</java.version>
   | </properties>
