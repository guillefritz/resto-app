
# Resto App by Guillermo Fritz

Demo application trying to follow the guidelines from EXAMEN-JAVA.pdf

## Global architecture

For productivity reasons the application is a single monolith, but should be splitted in at least two projects (front/back) for separation of concerns (see TODOs section).

## How to run the app

There are three options to run it:

*   Inside an IDE, running RestoApplication.java class
*   Using Maven, running: mvn package; java -jar target/resto-0.0.1-SNAPSHOT.jar
*	Using Maven, but running: mvn spring-boot:run 

Then open a browser and go to http://localhost:8080

## How to test it

Running: mvn test

## Frontend

Frontend part uses AdminLTE bootstrap template (https://github.com/almasaeed2010/AdminLTE/) + Angular (http, router)

Http endpoints are provided by MenuController bean.

## Backend

Backend made with MenuService -> MenuDAO

MenuDAO has an InMemory implementation for Demo purposes

## TODOs

*	Split the app into frontend and backend apps
*	Add more tests
*	List pagination (client or backend)
*	Backend filtering (actually is only frontend)
