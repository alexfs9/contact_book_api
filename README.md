# API REST developed in Spring Boot to manage contacts.

Spring Boot version: 3.3.1
  - Spring Web
  - Spring Data JPA
  - Validation
  - MySQL Driver
  - Lombok

# Configurations - application.properties:
  - spring.jpa.hibernate.ddl-auto=update
  - spring.datasource.url=jdbc:mysql://localhost:3306/contact_book_db (Create a database in MySQL and change the name here)
  - spring.datasource.username=root (Your username in MySQL)
  - spring.datasource.password=12345 (Your password in MySQL)
  - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  - spring.jpa.show-sql=true (Disable if you don't want to see the queries generated by Spring Boot in the terminal)
