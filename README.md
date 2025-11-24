# SPRING-BOOT-CRUD-API

Professional learning project: Spring Boot CRUD API (Maven, Java 17, Spring Boot 3)

Overview

This repository is a personal Spring Boot learning project developed and maintained by the author as a practice ground to learn Spring Boot and related technologies. The project implements a simple CRUD API backed by MySQL. All work in this repository was completed by the author without AI assistance or copying external source code.

Key details
- Build tool: Maven
- Java: 17
- Spring Boot: 3.x
- Database: MySQL
- Application artifact/context: crud / crudapp
- Default port: 8080
- Tests: none included

Table of contents
- Overview
- Technology stack
- Features
- Prerequisites
- Configuration
- Build and run
- API examples
- Deployment
- Contributing
- License
- Contact

Technology stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven

Features
- Standard CRUD operations (Create, Read, Update, Delete)
- Layered architecture (Controller -> Service -> Repository)
- MySQL persistence
- Example REST endpoints to demonstrate Spring Boot patterns

Prerequisites
- Java 17 JDK
- Maven 3.6+
- MySQL server
- Git

Configuration

1. Database
Create a MySQL database for the application, for example:

    CREATE DATABASE crud_db;

2. application.properties (example)

Place the following properties in src/main/resources/application.properties or set equivalent environment variables.

    # Server
    server.port=8080
    server.servlet.context-path=/crudapp

    # Datasource
    spring.datasource.url=jdbc:mysql://localhost:3306/crud_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=your_db_user
    spring.datasource.password=your_db_password

    # JPA/Hibernate
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true

Adjust these settings to match your local environment.

Build and run

From the repository root, build the project with Maven:

    mvn clean package

Run using Spring Boot Maven plugin:

    mvn spring-boot:run

Or run the generated jar:

    java -jar target/*.jar

The application will be available at http://localhost:8080/crudapp (unless you change the port or context path).

API examples

Below are example endpoints and sample curl commands. Replace {id} with an actual resource id and adjust payloads to match the entity model present in this repository.

Assuming an example entity named "item" with base path /api/items:

- Create

    curl -X POST http://localhost:8080/crudapp/api/items \
      -H "Content-Type: application/json" \
      -d '{"name":"Example Item","description":"A sample"}'

- Read all

    curl http://localhost:8080/crudapp/api/items

- Read by id

    curl http://localhost:8080/crudapp/api/items/{id}

- Update

    curl -X PUT http://localhost:8080/crudapp/api/items/{id} \
      -H "Content-Type: application/json" \
      -d '{"name":"Updated","description":"Updated description"}'

- Delete

    curl -X DELETE http://localhost:8080/crudapp/api/items/{id}

Notes
- The exact endpoint paths, request/response payloads, and entity names depend on the code in src/. Update the examples above to match the entities present in the repository.
- The sample application.properties above uses spring.jpa.hibernate.ddl-auto=update for development convenience. For production systems, use managed migration tools (Flyway or Liquibase) and more strict settings.

Deployment

- Containerization: Add a Dockerfile and compose file to run the app with MySQL for containerized deployments.
- Cloud: The app can be deployed to any Java-supporting platform; ensure you provide the correct datasource settings for the target environment.

Contributing

This repository is primarily a personal learning project. Contributions or feedback are welcome — please open an issue or a pull request if you wish to suggest improvements.

License

This project is licensed under the MIT License — see the LICENSE file for details.

Contact

Maintainer: ASWIN-SENTHILKUMAR2006
Email: aswinsenthilkumarcse@gmail.com

Acknowledgements

This project is intended as a personal learning exercise. All work in this repository was completed by the author without the assistance of AI tools or copying external code. The code is updated progressively as the author learns new concepts and practices.
