# canbeer 

A simple Beer API (with a few select beers from my favourite places in Quebec City)

This project serves as a demo platform for many things. 

As of now (March 6 2019):

* A REST API in Kotlin using Spring Boot
* Security provided by OAuht2 / Spring Security / Keycloak
* An Angular frontend application

## Getting Started

* clone the project
* start the Keycloak server using the docker-compose file (keycloak-compose.yml)
* configure the keycloak server (TODO)
* start the backend : `$ gradlew bootRun`
* start the frontend : `$ src/ng-beer/ng serve`
