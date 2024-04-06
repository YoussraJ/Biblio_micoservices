# Microservices Project README

## Dependencies:

### 1. Spring Boot Dependencies:
- `spring-boot-starter-actuator`
- `spring-boot-starter-data-r2dbc`
- `spring-boot-starter-web`
- `spring-boot-starter-webflux`

### 2. Spring Cloud Dependencies:
- `spring-cloud-starter-config`
- `spring-cloud-starter-netflix-eureka-client`

### 3. MySQL Database Dependencies:
- `mysql-connector-j`
- `r2dbc-mysql`

### 4. Lombok (for reducing boilerplate code):
- `lombok`

### 5. Spring Kafka for Kafka integration:
- `spring-kafka`

### 6. Testing Dependencies:
- `spring-boot-starter-test`
- `reactor-test`
- `spring-kafka-test`

### 7. Flyway for Database Migrations:
- `flyway-mysql`
- `flyway-core`

## BEFORE RUNNING THE PROJECT:
- Start MySQL server.
- Create databases: `users` (for Users microservices) and `emprunt` (for Emprunts microservices).
- Run Kafka depending on your OS:
  - If you're using Windows, open two terminals in the Kafka directory:
    - Terminal 1: `.\zookeeper-server-start.bat ..\..\config\zookeeper.properties`
    - Terminal 2: `./kafka-server-start.bat ..\..\config\server.properties`
  - That's it! You can execute all microservices.
