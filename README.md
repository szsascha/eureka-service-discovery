# Eureka service discovery

This project shows a simple implementation of Spring Cloud Netflix Eureka and Spring Cloud OpenFeign.

Eureka is used as a registry for all started services and Feign is used to call another service, just by its name. The combination of Eureka and Feign also provides a load balancing to distribute the requests to all available instances of a service.

# Setup

1. Clone this repository
2. Run `mvn clean install` in the root dir

# Run the environment

1. Start Eureka by `cd` into `spring-cloud-eureka` and run `mvn spring-boot:run`
2. Start multiple instances of the city service by `cd` into `city-service` and run `mvn spring-boot:run` multiple times in different terminal sessions
3. Start the address service by `cd` into `address-service` and run `mvn spring-boot:run`

# Test and check the running services

1. Open `http://localhost:8761` to see if the services are listed in Eureka
2. Check the randomly assigned serverport of the address-service in the console
3. Send a REST request to the address-service: `GET http://localhost:PORT/addresses/Sample`

The address-service calls each time the city-service to determine the name of a city by the given country and postalcode. You also should see this requests in the logs. Each time another instance of city-service should be requested.