# Microservices - Assignment 7 - Endpoint Implementation Planning

## Purpose / Objectives

- Code an endpoint for your group project that handles mappings for 
    - GET
    - POST
    - PUT
    - DELETE
- Show understanding of the layers - controller, service, repository, DTO, model

## Assignment Description

In class Tuesday, you built your project using the Assignment 7 repository. For this assignment, continue building on that codebase. In class Thursday, you and your group will get assistance building **one endpoint**.

To prepare, you are going to sketch out the design plan for **one** endpoint in code.  By sketching, we are expecting comments and comment blocks of larger logical chunks, and methods to be stamped.

Minimum requirements for credit:
    - build folders for the layers and flesh out the required Java class files for the Controller, Service, Repository, DTO, and Model for the endpoint you are focusing on. 
    - sketch out methods for GET, POST, PUT, and DELETE request mappings at the Controller layer
    - sketch out helper methods at the Service layer
    - sketch out DTO class with datatypes & values needed, noting which need to be `@NotBlank`
    - sketch help methods at the Repository layer, noting needs for custom `nativeQuery` or what `JPARepository` built in methods you should be able to leverage (ex. `deleteById`, `save`)
    - sketch out entity models based on the DB table columns and needed table joins to present all info about an entity
    - Additional considerations
        - where, and at what layers, are you going to throw exceptions
        - required versus not required data fields

I will leave it up to groups on if they want everyone to make a plan for the same endpoint or a unique endpoint.  The goal for Thursday remains get **one working**.

## Deliverable

Add your code and comment sketches for implementation to the `microservices-assignment-7-YOURUSERNAME` repository.

Submit your link to the Assignment 7 Dropbox in Pilot.

## Rubric

Microservices Assignment 7 Grading

Score:  / 7 points

- Folders built for layers & contain named classes ( / 1 pt)
- Controller has methods and comment sketches for GET, POST, PUT, and DELETE mappings ( / 1 pt)
- Service has methods and comment sketches appropriate to taskings ( / 1 pt)
- DTO sketches fields for object and notes what should be `@NotBlank` ( / 1 pt)
- Repository sketches needs for `nativeQuery` methods versus usable `JPARepository` built-in methods ( / 1 pt)
- Models sketches primary table and joins to other tables as required to get entity information ( / 1 pt)
- Sketches in layers note where exceptions should be thrown and what data is required to be passed ( / 1 pt)

Feedback: 
