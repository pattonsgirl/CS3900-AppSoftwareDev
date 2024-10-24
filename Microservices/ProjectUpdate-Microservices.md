# Microservices - Group Project Additions

## Purpose / Objectives

- Defining API endpoints
- Defining method taskings at layers - Controller, Service, Repository, DTO, and Model
- Building GET, POST, PUT, and DELETE endpoints for resource
- Testing API endpoints with tool (Swagger)

## Description

If you have not already, join your group's GitHub repository and clone the repository to your system.

Check that you can build and connect to your group project database and have a current copy of any revisions made using the feedback from the DB team.

Revisit your team's proposed wireframes and apply feedback from the UIUX team.  The wireframes will provide foundation for your project's endpoints.

Through the microservices unit, you have been detangling layers & mappings for endpoints.  The group project will have you defining and implementing endpoints for your group project.

In your group project GitHub repository, create a folder named `PROJECTTHEME-service`, replacing PROJECTHEME with your group's project theme.  
    - Add a folder named `READMES` to the `PROJECTTHEME-service` folder.  
    - Have **ONE TEAM MEMBER** copy in their Assignment 7 code to the `PROJECTTHEME-service` folder, at minimum with a working `healthcheck` GET endpoint.  Verify all team members can pull this base and run the project on their system.
    - Add common exception class files from the [WorkOrder Pro `exception` folder](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/tree/main/Microservices/work-order-pro-service/src/main/java/com/wsu/workorderproservice/exception) - adjust to refer to your project package.

This is where GitHub repository version management is going to come in clutch.
> [!TIP] 
> Have team members build their endpoints on different branches.  Name the branch with the corresponding endpoint.  Merge branches with `main` once branch endpoint is built and tested.

**Since each team member built a wireframe, I recommend having the same team member who built the wireframe take lead in building the endpoint.**

For each application endpoint, there will be two deliverables:
1. The code for the endpoint
2. An `ENDPOINTNAME-README.md` file in the folder named `READMES` where `ENDPOINTNAME` is the name of the endpoint.

### `ENDPOINTNAME-README.md` Taskings

This README will serve as the design and justification document for the endpoint.  There are 4 potential endpoint mappings for a resource:
- GET (return data / return data based on a search term)
- POST (add new entry)
- PUT (update fields in existing entry)
- DELETE (remove data entry)

For each mapping the endpoint supports, document 
1. What the mapping must ingest from the frontend (for example: user provides a search term; user provides an entry identifier?)
2. What the mapping will return (for example: all entries that match a phrase; an updated data entry)
3. What the database query needs to be (what table(s), what column(s), etc.)

Not every resource will need GET, POST, PUT, and DELETE.  For example, in the context of WorkOrder Pro, work orders in the system can have their status change, but work orders cannot be deleted (no DELETE mapping - why would a business delete that a work order was generated?).  If your endpoint **should not support a mapping** justify why the mapping is not suitable from a business logic perspective.

### Endpoint Code Taskings

**For each resource** create Java class files for the Controller, Service, DTO, and Model layers. Create Interface for Repository layer.

You may lean on the WorkOrder Pro service the microservices team built. Cite by link or filename what file you got your code idea / snippet from (this will help the team when detangled how you arrived at certain logic).

Resource Controller class contains:
- add required springframework & lombok annotations
- request mapping
- GET, POST, PUT, and / or DELETE mappings (with additional mapping info if needed, such as how PUT needs to ingest which entry to update)
- For appropriate mapping add `if` statements only where Bean Validation not applied
- For each mapping, calls to appropriate methods in the Service layer
- For each mapping, return data and HTTP status codes for future frontend ingestion
- [WorkOrder Pro Endpoint Controller files](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/work-order-pro-service/src/main/java/com/wsu/workorderproservice/controller/) 

Resource Service class contains:
- add required springframework & lombok annotations
- add `if` statement(s) in case if needed
- add `try / catch` blocks to execute business logic and handle exceptions.
- appropriate mapper methods to convert entity model class to DTO and vice versa
- [WorkOrder Pro Endpoint Service files](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/tree/main/Microservices/work-order-pro-service/src/main/java/com/wsu/workorderproservice/service)

Resource Repository interface contains:
- extends `JpaRepository<T, ID>` (here T is resource entity model class and ID is the primary key datatype)
- custom `nativeQueries` methods to return data based on specific search (as required)
- [WorkOrder Pro Endpoint Repository files](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/tree/main/Microservices/work-order-pro-service/src/main/java/com/wsu/workorderproservice/repository)

Resource DTO class contains:
- add required lombok annotations 
- declare fields with appropriate datatype based on endpoint design.
- add `@NotBlank` with appropriate message where fields cannot be `null` or blank
- [WorkOrder Pro Endpoint DTO files](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/tree/main/Microservices/work-order-pro-service/src/main/java/com/wsu/workorderproservice/dto)

Resource Model class contains:
- Add required jakarta & lombok annotations
- `@Table` annotation to customize the mapping between an entity class and the corresponding database table
- mappings to table columns and entity fields
- add JPA relationship mapping where appropriate if entity information is combination of information from other tables
- [WorkOrder Pro Endpoint Model files](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/tree/main/Microservices/work-order-pro-service/src/main/java/com/wsu/workorderproservice/model)

### Github repository Expectations

`main` branch contains only **working** endpoints.  If the endpoint does not work, leave it in its branch or repository for continued development.  For their contributions to count, have documentation make clear to the microservices team about where to find the work.  Your code on the `main` branch should always be operational (as in the application will start and working endpoints will respond)

### Honors / Bonus Requirements

For a **minimum of one endpoint**:
    - GET mapping uses pagination
    - endpoint has a working Swagger `.yml` file that tests the endpoint's mappings
        - add this to a folder named `SWAGGER` in your group project folder

## Deliverables

- Endpoint code developed by each team member.  If the team member does not have a working endpoint, do not merge their code into `main`
- `ENDPOINT-README` in `READMES` folder

## Submission

Submit link to assignment repository in the Dropbox in Pilot.  Only ONE team member needs to remember to submit the link.

URL looks like: https://github.com/WSU-kduncan/cs3900-YOURGROUPNAME

## Rubric

Team members with no contributions to the team project GitHub repository will receive a 0.

If a team member did not build the endpoint they were tasked with, the participating team members will not take a penalty.

If a team member helps another team member within polishing / debugging an endpoint (and therefore makes contributions), there will not be a penalty on the team member who requested help.

If an endpoint is not working (incomplete), partial credit is available for the work that was done.

Score: Total points among complete & incomplete endpoints

For each completed endpoint:
- Endpoint README contains reasonable mapping plans aligned with code implementation - 1 pt
- Resource Controller class ingests & returns data appropriate to endpoint mapping - 1 pt
- Resource Services class provides reasonable help methods between Controller & Repository layers - 1 pt
- Resource Repository class contains extends `JPARepository` and appropriate native queries - 1 pt
- Resource DTO class defines object fields and identifies which fields cannot be blank - 1 pt
- Resource Model class maps entity to database tables - 1 pt

For each incomplete endpoint:
- Endpoint README contains reasonable mapping plans aligned with code implementation - 1 pt
- Resource Controller class outlines how to ingest & return data appropriate to mapping - 1 pt
- Resource Services class outlines reasonable help methods between Controller & Repository layers - 1 pt
- Resource Repository class contains extends `JPARepository` and outlines appropriate native queries - 1 pt
- Resource DTO class outlines object fields and identifies which fields cannot be blank - 1 pt
- Resource Model class outlines mapping of entity to database tables - 1 pt

Honors / Bonus requirements:
- For a **minimum of one endpoint**:
    - GET mapping uses pagination
    - endpoint has a **working** Swagger `.yml` file that tests the endpoint's mappings





