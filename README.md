micro services 
# Dependencies:

# 1/Spring Boot Dependencies:
spring-boot-starter-actuator
spring-boot-starter-data-r2dbc
spring-boot-starter-web
spring-boot-starter-webflux

# 2/Spring Cloud Dependencies:
spring-cloud-starter-config
spring-cloud-starter-netflix-eureka-client

# 3/MySQL Database Dependencies:
mysql-connector-j
r2dbc-mysql

# 4/Lombok (for reducing boilerplate code):
lombok

# 5/Spring Kafka for Kafka integration:
spring-kafka

# 6/Testing Dependencies:
spring-boot-starter-test
reactor-test
spring-kafka-test

# 7/Flyway for Database Migrations:
flyway-mysql
flyway-core  


# BEFORE RUNNIG THE PROJECT !!!!!!
-Start mySql server
-create databases (users(for Users microservices) and emprunt(for Emprunts microservices))
- runnig kafka depending on your OS (if your are using windows open two terminals on the windows folder in your kafka directory then tap commands :
    terminal 1: .\zookeeper-server-start.bat ..\..\config\zookeeper.properties
    terminal 2: ./kafka-server-start.bat ..\..\config\server.properties
 that's it! you can execute all microservices
