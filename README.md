# Just Cinemas API

REST APIs exposed to perform operations required to manage ticket bookings for Just Cinemas

# Technologies:
 1. Java 1.8
 2. PostGreSQL 11 DB

# Libraries
 1. Spring Boot 1.4.1
 2. Flyway 4.0.3
 3. JOOQ 1.0.5

# Testing Frameworks
 1. Junit 4
 2. Mockito 1.10.19

# Project Setup
 1. Clone the repository
 2. Setup the project using gradle
 3. Start a postGreSQL instance and create a database
 4. Change following properties in in application.yml to connect to your postgres instance:
       spring.datasource.url
       spring.datasource.username
       spring.datasource.password
 5. To build the project run:
       ```./gradlew clean build```
 6. To run test locally run:
       ```./gradlew clean test```
 7. Once the postgres instance is running run
        ```./gradlew bootRun```

# Deployment
 1. Clone the repository
 2. Then follow the instruction on the https://github.com/Sethuraman/bootcamp-gocdinfra to complete the deployment
 3. You can test your API deployment by running the below command
   ```curl <your deployed ip address>/movies/now-showing``` If this print out json then your deployment has worked. Be aware, that the curl endpoint might take a while before it works. Track the API deployment via the cloudformation console.
 4. Get the IP address of the EC2 box created to host your API and provide update in the build stage of the UI project build. You can test

