
# Building Endpoints with SpringBoot

## What is SpringBoot?

~~A hot mess until you've used it a few times.~~


## Understanding CRUD & REST APIs

This article does **excellent** coverage on what a RESTful API is, explains GET, PUT, POST, and DELETE, and shows examples of the HTTP structure of each.

**READ THIS**

[RESTful API - HTTP Methods](https://restfulapi.net/http-methods/)

## How are SpringBoot applications organized?

The module instructors are going to organize the code **by layer** not by feature.  If it was by feature, we would see folders called `technician` with technician related layers inside.  Instead most common practice is to organize by layer, and have classes that focus on topics, like technician.

![Structure by Layer or Feature?](https://raw.githubusercontent.com/danvega/code-structure/refs/heads/main/package-by-layer-feature.png)

![SpringBoot Architecture](https://www.interviewbit.com/blog/wp-content/uploads/2022/06/Spring-Boot-Workflow-Architecture-800x480.png)

## What is the overall goal?

Right now, we are looking at how to interact with our database by building a REST controller.  

In class, we will build this out for WorkOrder Pro.  We already have a database with information of work orders, technicians, and other entitites.  

Now we are going to build out GET (retrieve / look up only), POST (create new), PUT (update existing), and DELETE (remove) by processing HTTP requests, making database lookups or modifications (as appropriate), and returning structured responses.

In the FRONTEND module of the course, we will take the need for structured data inputs and the return of structured responses and display them on proper pages.  For now, it's all data.

In assignment 1, we test the GET response of the `/healthcheck` endpoint.  This is defined in `HealthController.java` in `controller`

Our next step is to build the ability to query for and return reponses on the technicians table.  Since our first focus is querying, we will build a GET endpoint.  The assumption is there could be many pages of matches, and maybe only so many per page should show at a time.  The response is pre-built around this assumption.  This will help later when we are displaying the response nicely on web pages.

## ChatGPT Breaksdown Technicians Controller:

[TechnicianController.java in controller folder](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/Live%20Coding/Class-1/work-order-pro-service/src/main/java/com/wsu/workorderproservice/controller/TechnicianController.java)

This code defines a **Spring Boot controller** that handles HTTP GET requests for retrieving a paginated, sortable list of **technicians**. It uses Spring’s web framework and some custom business logic to achieve this functionality. Let’s go over the key components and break down how they work:

### 1. **Package and Imports**
```java
package com.wsu.workorderproservice.controller;

import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.dto.TechnicianDTO;
import com.wsu.workorderproservice.service.TechnicianService;
import com.wsu.workorderproservice.utilities.Constants;

import lombok.RequiredArgsConstructor;
```
- **Package Declaration**: The class belongs to `com.wsu.workorderproservice.controller`.
- **Imports**: Imports necessary libraries and classes like:
  - `Page`: For paginated results.
  - `ResponseEntity` and `HttpStatus`: To return structured HTTP responses.
  - `RequestParam`: For handling query parameters from requests.
  - `TechnicianDTO`: A Data Transfer Object that represents the technician data.
  - `TechnicianService`: A service class where the business logic for fetching technicians resides.
  - `Constants`: A utility class holding constant values used across the application (e.g., default sort order).
  - **Lombok**'s `@RequiredArgsConstructor` automatically generates a constructor for final fields.

### 2. **Class-Level Annotations**
```java
@RestController
@RequiredArgsConstructor
@RequestMapping("technicians")
public class TechnicianController {
```
- **`@RestController`**: Marks this class as a Spring REST controller, meaning the class will handle HTTP requests and responses, with the return values automatically serialized as JSON (or XML).
- **`@RequiredArgsConstructor`**: Provided by Lombok, this annotation generates a constructor for any final fields in the class, in this case, `technicianService`. This allows dependency injection to occur automatically without the need for explicit constructors.
- **`@RequestMapping("technicians")`**: All endpoints in this controller will be available under the base path `/technicians`.

### 3. **Field Declaration**
```java
private final TechnicianService technicianService;
```
- **`TechnicianService`**: A service class that handles the business logic of fetching and manipulating technician data. It's marked `final` and initialized via constructor injection (thanks to `@RequiredArgsConstructor`).

### 4. **GET Endpoint**
```java
@GetMapping
public ResponseEntity<ServiceResponseDTO> get(@RequestParam(required = false) String search, 
    @RequestParam(required = false, defaultValue = "1") Integer page, 
    @RequestParam(required = false, defaultValue = "10") Integer rpp, 
    @RequestParam(required = false, defaultValue = "technicianCode") String sortField, 
    @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder) {
```
- **`@GetMapping`**: Maps HTTP GET requests to this method. Since no additional path is provided, this method will respond to GET requests at `/technicians`.
- **Method Parameters**:
  - **`@RequestParam`**: Used to bind query parameters from the URL to the method parameters. All these parameters are optional (`required = false`), with some having default values.
    - `search`: A string used to filter the results, allowing users to search for specific technicians (optional).
    - `page`: The page number to retrieve for pagination. Defaults to `1`.
    - `rpp`: Results per page (number of records returned per page). Defaults to `10`.
    - `sortField`: The field by which to sort the results (e.g., `technicianCode`). Defaults to `"technicianCode"`.
    - `sortOrder`: The order in which to sort the results (e.g., ascending or descending). Defaults to `DESC` (descending), which is defined in the `Constants` class.

### 5. **Service Call and Pagination**
```java
Page<TechnicianDTO> technicianDTOPage = technicianService.get(search, sortField, sortOrder, page, rpp);
```
- **`technicianService.get()`**: This service method is called to retrieve a paginated list of technicians based on the search term, sorting criteria (`sortField`, `sortOrder`), page number (`page`), and number of results per page (`rpp`).
- **`Page<TechnicianDTO>`**: The result is a paginated `Page` object, which holds both the list of technicians (`TechnicianDTO`s) and pagination metadata (like the total number of pages and total number of elements).

### 6. **Building the Response**
```java
return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(
    Constants.MESSAGE, "Technicians retrieved successfully", 
    Constants.PAGE_COUNT, technicianDTOPage.getTotalPages(), 
    Constants.RESULT_COUNT, technicianDTOPage.getTotalElements()))
    .data(technicianDTOPage.getContent())
    .build(), HttpStatus.OK);
```
- **ServiceResponseDTO**: A custom DTO that wraps the response data and metadata. The `.builder()` method is used to create this object in a readable, step-by-step manner.
  - **`meta`**: This is metadata added to the response, in this case:
    - `Constants.MESSAGE`: A success message (`"Technicians retrieved successfully"`).
    - `Constants.PAGE_COUNT`: Total number of pages available (from `technicianDTOPage.getTotalPages()`).
    - `Constants.RESULT_COUNT`: Total number of results (from `technicianDTOPage.getTotalElements()`).
  - **`data`**: The actual list of technician records (from `technicianDTOPage.getContent()`), returned in the response.
- **`ResponseEntity`**: This class represents the entire HTTP response, including the status code and body.
  - The body is the built `ServiceResponseDTO` object.
  - **`HttpStatus.OK`**: A 200 OK status code indicating that the request was successful.

### Key Points Recap:
1. **Controller**: Handles HTTP GET requests to `/technicians` and allows for flexible query filtering, pagination, and sorting.
2. **TechnicianService**: Responsible for handling the logic of fetching technicians based on the provided query parameters.
3. **Pagination**: Uses the `Page` object to return both the list of technicians and metadata like the total number of pages and results.
4. **DTOs**: Structures the response in a clear way using `ServiceResponseDTO` for both metadata and actual technician data.
5. **ResponseEntity**: Wraps the response object with an HTTP status to send a properly formatted response back to the client.

This controller is an example of a well-structured RESTful API with pagination, sorting, and query capabilities.

## ChatGPT Breaksdown Service DTO

[ServiceResponseDTO.java in dto](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/Live%20Coding/Class-1/work-order-pro-service/src/main/java/com/wsu/workorderproservice/dto/ServiceResponseDTO.java)

This code defines a **Data Transfer Object (DTO)** called `ServiceResponseDTO`, which is used to structure responses in a consistent and flexible way. It uses the **Lombok** library to generate common methods like constructors, getters, and setters, making the class easier to manage by reducing boilerplate code.

### Breakdown of Key Components

#### 1. **Package Declaration**
```java
package com.wsu.workorderproservice.dto;
```
- The `ServiceResponseDTO` class is part of the `com.wsu.workorderproservice.dto` package. This suggests it's intended to be used for sending data between different layers of the application, typically as a response to client requests.

#### 2. **Imports**
```java
import java.util.Map;
```
- **`Map`**: This class is used to hold key-value pairs. In this case, `meta` is a map that can contain various pieces of metadata related to the response (like pagination info, status messages, etc.).

#### 3. **Lombok Annotations**
```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
```
- **`@Builder`**: This annotation allows for the creation of objects using the **builder pattern**. Instead of using a long constructor with many parameters, the builder pattern provides a more readable and flexible way to create instances of the class.
- **`@Getter`**: Automatically generates getter methods for all the fields in the class. For example, it generates `getMeta()` and `getData()`.
- **`@Setter`**: Automatically generates setter methods for all the fields in the class. For example, it generates `setMeta(Map<String, Object> meta)` and `setData(Object data)`.
- **`@NoArgsConstructor`**: Generates a **no-argument constructor**. This allows the class to be instantiated without any parameters (i.e., `new ServiceResponseDTO()`).
- **`@AllArgsConstructor`**: Generates a **constructor with parameters for all fields**. This allows you to create an instance with all fields set at once (i.e., `new ServiceResponseDTO(meta, data)`).

#### 4. **Class Definition**
```java
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponseDTO {
```
- The class is designed to encapsulate responses that are sent to clients or other services. It consists of two main fields: `meta` and `data`.

#### 5. **Fields**
```java
private Map<String, Object> meta;
private Object data;
```
- **`meta`**: A `Map<String, Object>` that contains metadata related to the response. Metadata could include information such as:
  - Status messages (e.g., success, failure, warnings)
  - Pagination details (e.g., page number, total pages)
  - Custom metadata relevant to the specific service (e.g., execution time)
  
  The `String` key represents the name of the metadata (e.g., `"message"` or `"pageCount"`), while the `Object` value can represent any type of data.

- **`data`**: An `Object` that holds the main data payload of the response. This could be:
  - A single entity (e.g., `TechnicianDTO`)
  - A list of entities
  - Any type of object that represents the actual data being returned by the service. Since it’s typed as `Object`, it’s flexible enough to handle various data structures.

### Example of How It Could Be Used:

Let’s say a service method fetches a list of technicians and also wants to return a message and pagination details. This is how you might create a response using `ServiceResponseDTO`:

```java
Map<String, Object> meta = Map.of(
    "message", "Technicians retrieved successfully",
    "pageCount", 5,
    "resultCount", 50
);

List<TechnicianDTO> technicians = List.of(technician1, technician2, technician3);

ServiceResponseDTO response = ServiceResponseDTO.builder()
    .meta(meta)
    .data(technicians)
    .build();
```

In this example:
- **`meta`**: Contains information about the total number of pages (`pageCount`), the total number of results (`resultCount`), and a success message (`message`).
- **`data`**: Contains the actual list of `TechnicianDTO` objects that were retrieved from the service.

### How It's Typically Used:
In a REST API, the `ServiceResponseDTO` might be returned as the body of an HTTP response:

```java
@GetMapping("/technicians")
public ResponseEntity<ServiceResponseDTO> getTechnicians() {
    Map<String, Object> meta = Map.of("message", "Technicians retrieved", "pageCount", 10);
    List<TechnicianDTO> technicians = technicianService.getAllTechnicians();
    
    ServiceResponseDTO response = ServiceResponseDTO.builder()
        .meta(meta)
        .data(technicians)
        .build();
    
    return new ResponseEntity<>(response, HttpStatus.OK);
}
```

In this example, when a client makes a GET request to `/technicians`, they receive a structured response that includes both the `meta` information (e.g., a success message, pagination details) and the actual data (i.e., the list of technicians).

### Summary:
- **`ServiceResponseDTO`** is a data transfer object used to structure responses in a flexible way.
- It has two fields: 
  - **`meta`**: A map for metadata like status messages, pagination details, or other response-related information.
  - **`data`**: The actual data payload, which could be any object (e.g., a list of entities).
- **Lombok** annotations automatically generate useful methods such as getters, setters, and constructors.
- The **builder pattern** makes constructing the DTO flexible and readable, especially when there are multiple fields.

## ChatGPT Breaksdown Technician DTO

[TechnicianDTO.java in DTO folder](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/Live%20Coding/Class-1/work-order-pro-service/src/main/java/com/wsu/workorderproservice/dto/TechnicianDTO.java)

This code defines a **Data Transfer Object (DTO)** called `TechnicianDTO` using Java and the **Lombok** library. A DTO is a simple Java class used to carry data between processes, typically between the application and the client or a service layer. Let's go through the key parts of the code:

### 1. **Package Declaration**
```java
package com.wsu.workorderproservice.dto;
```
- The class `TechnicianDTO` belongs to the `com.wsu.workorderproservice.dto` package. This suggests it's part of the "Data Transfer Object" layer in the `workorderproservice` application.

### 2. **Imports**
```java
import java.lang.Thread.State;
import java.util.Set;
```
- **`State`**: Refers to `java.lang.Thread.State`, which is an enum representing the states a Java thread can be in (e.g., `NEW`, `RUNNABLE`, `BLOCKED`). It's likely being used to represent the work permit states for a technician.
- **`Set`**: A collection that holds a set of unique `State` objects (e.g., the various work permits a technician holds).

### 3. **Lombok Annotations**
The class uses **Lombok** annotations to reduce boilerplate code like getters, setters, constructors, and builders. These annotations are processed at compile time and generate the required code.
```java
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
```
- **`@Builder`**: Generates a builder pattern for the class. This allows for a more flexible and readable way to create instances of `TechnicianDTO`, especially when some fields are optional.
- **`@Getter`**: Generates getter methods for all fields, so you can access the values (e.g., `getFirstName()`).
- **`@Setter`**: Generates setter methods for all fields, so you can modify the values (e.g., `setFirstName(String firstName)`).
- **`@NoArgsConstructor`**: Generates a no-argument constructor. Useful for frameworks (like Hibernate) that require a default constructor.
- **`@AllArgsConstructor`**: Generates a constructor with all fields as parameters, allowing you to create an object with all properties set.

### 4. **Fields (Attributes)**
These represent the data that the `TechnicianDTO` holds:
```java
private String code;
private String firstName;
private String lastName;
private String type;
private String latestWorkOrderStatus;
private Set<State> workPermits;
```

- **`code`**: Represents the unique identifier or code for the technician (likely an alphanumeric string).
- **`firstName`**: The technician’s first name.
- **`lastName`**: The technician’s last name.
- **`type`**: This could represent the technician's job category or role (e.g., `electrician`, `plumber`).
- **`latestWorkOrderStatus`**: Stores the status of the technician's most recent work order (e.g., `completed`, `in-progress`).
- **`workPermits`**: A `Set` of `State` objects representing the technician’s work permits. These permits might indicate various legal or operational statuses that a technician must comply with (though the exact use of `Thread.State` here could be confusing, as it's usually related to Java threads, not permits).

### Example of Usage:
```java
// Using the Builder pattern to create an instance of TechnicianDTO
TechnicianDTO technician = TechnicianDTO.builder()
    .code("TECH001")
    .firstName("John")
    .lastName("Doe")
    .type("Electrician")
    .latestWorkOrderStatus("Completed")
    .workPermits(Set.of(State.RUNNABLE, State.BLOCKED))
    .build();
```

### Key Takeaways:
- **DTO Purpose**: `TechnicianDTO` is a data transfer object that encapsulates data about a technician, likely used for sending technician data between different parts of the application, such as between a controller and a service, or between a service and a client.
- **Lombok Usage**: Lombok annotations like `@Getter`, `@Setter`, `@Builder`, etc., are used to avoid manually writing boilerplate code.
- **Work Permits Field**: The `workPermits` field is a `Set` of `State`, where `State` is typically used for Java thread states. This usage might imply some specific context, or it could be a placeholder for another state or permission-based enum related to technicians' work permits.

If you're seeing `Thread.State` used for `workPermits`, it may be an unconventional choice. It might make more sense to define a custom enum for the work permit states.

## ChatGPT Explains Techinican Service

[TechnicianService.java in service folder](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/Live%20Coding/Class-1/work-order-pro-service/src/main/java/com/wsu/workorderproservice/service/TechnicianService.java)

This code defines a **service class** in a Spring Boot application that deals with retrieving technicians. The class `TechnicianService` contains a method `get` that is intended to return a paginated list of technicians based on search, sorting, and pagination criteria. However, the method is currently returning `null`, indicating that it's a placeholder for the actual implementation. Let's break down the key parts of this code:

### 1. **Package Declaration and Imports**
```java
package com.wsu.workorderproservice.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.wsu.workorderproservice.dto.TechnicianDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
```
- The class belongs to the `com.wsu.workorderproservice.service` package, which is typically where service classes reside in a Spring Boot application.
- **Imports**:
  - **`Page`**: From Spring Data, this is a useful class for handling paginated results. A `Page<T>` is a wrapper around a list of objects that also includes pagination metadata like the total number of pages and the current page.
  - **`Service`**: Indicates that this class is a service layer component. It is used for defining business logic and is picked up by Spring's component scanning, making it a Spring-managed bean.
  - **`TechnicianDTO`**: A DTO class used to transfer technician data.
  
### 2. **Class-Level Annotations**
```java
@Service
@RequiredArgsConstructor
@Slf4j
public class TechnicianService {
```
- **`@Service`**: Marks the class as a service, meaning it will contain business logic and be a candidate for dependency injection.
- **`@RequiredArgsConstructor`**: Provided by Lombok, this generates a constructor for any `final` fields in the class. Since there are no fields declared here, it has no immediate effect, but if dependencies are added later, Lombok will create the required constructor automatically.
- **`@Slf4j`**: Another Lombok annotation that provides a **logger** instance (`log`) for the class. You can use this to log information at various log levels (`INFO`, `DEBUG`, `ERROR`, etc.) throughout the class. It simplifies the use of a logging framework.

### 3. **Method Definition**
```java
public Page<TechnicianDTO> get(String search, String sortField, 
    String sortOrder, Integer page, Integer rpp) {
    return null;
}
```
- **Method Purpose**: This method is intended to retrieve a paginated and sorted list of technicians based on the input parameters, but it's currently not implemented (it returns `null`).
- **Method Signature**:
  - **`public Page<TechnicianDTO> get(...)`**: The method is expected to return a **`Page<TechnicianDTO>`** object, which holds a list of `TechnicianDTO` objects along with pagination details.
  - **Parameters**:
    - **`String search`**: A search term to filter technicians (e.g., by name or other fields).
    - **`String sortField`**: The field by which to sort the results (e.g., technician's code or name).
    - **`String sortOrder`**: The order of sorting, likely either `"asc"` for ascending or `"desc"` for descending.
    - **`Integer page`**: The page number to return (used for pagination).
    - **`Integer rpp`**: The number of records per page (results per page).
  
### 4. **Return Statement**
```java
return null;
```
- This method currently returns `null`, meaning it is not implemented yet. In a complete implementation, it would:
  - Interact with the **repository layer** (probably a `TechnicianRepository`) to fetch the relevant data from a database.
  - Apply the search, sorting, and pagination parameters to the query.
  - Return the results as a `Page<TechnicianDTO>`, including both the list of technicians and pagination metadata.

### Key Points:

1. **`TechnicianService`**: This service is responsible for implementing business logic related to fetching technicians. However, this logic is currently not present.
   
2. **Return Type (`Page<TechnicianDTO>`)**: The method is expected to return a **paginated** list of `TechnicianDTO`s (technician data objects). A `Page` object is useful because it encapsulates both the list of technicians as well as pagination information like the total number of pages and the current page.

3. **Search, Sorting, and Pagination**: 
   - **Search**: A search term allows filtering of technicians based on specific criteria (like a name or job type).
   - **Sorting**: `sortField` and `sortOrder` allow the results to be sorted by a given field (e.g., name or code) in ascending or descending order.
   - **Pagination**: `page` and `rpp` control which page of results to return and how many results to show per page, respectively.

4. **Logging**: 
   - The **`@Slf4j`** annotation provides a logger instance. In a real implementation, you could add log statements like:
     ```java
     log.info("Fetching technicians with search term: {}", search);
     ```

### Hypothetical Future Implementation:
In the future, you might expect this method to interact with a repository to fetch data. Here’s an example of what the actual implementation might look like:

```java
public Page<TechnicianDTO> get(String search, String sortField, 
    String sortOrder, Integer page, Integer rpp) {
    
    // Log search and sorting parameters
    log.info("Fetching technicians with search: {}, sortField: {}, sortOrder: {}", search, sortField, sortOrder);
    
    // Create Pageable object to define pagination and sorting
    Pageable pageable = PageRequest.of(page - 1, rpp, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
    
    // Perform search and return paginated results
    Page<Technician> technicianPage;
    if (search != null && !search.isEmpty()) {
        technicianPage = technicianRepository.searchByTerm(search, pageable);
    } else {
        technicianPage = technicianRepository.findAll(pageable);
    }

    // Convert entities to DTOs
    Page<TechnicianDTO> technicianDTOPage = technicianPage.map(technician -> modelMapper.map(technician, TechnicianDTO.class));
    
    return technicianDTOPage;
}
```

- This uses a `Pageable` object to apply pagination and sorting.
- It interacts with a `TechnicianRepository` to fetch results from the database.
- It maps the database entities (e.g., `Technician`) to DTOs (`TechnicianDTO`).

### Summary:
- This service class defines a method to retrieve technicians based on search, sorting, and pagination criteria.
- The method is not yet implemented, but when completed, it will handle the business logic of fetching technician data.
- It uses the `Page<TechnicianDTO>` type to return paginated results.
- Lombok annotations simplify logging (`@Slf4j`) and constructor injection (`@RequiredArgsConstructor`).

## ChatGPT Explains State in `model`

[State.java in model folder](https://github.com/pattonsgirl/CS3900-AppSoftwareDev/blob/main/Microservices/Live%20Coding/Class-1/work-order-pro-service/src/main/java/com/wsu/workorderproservice/model/State.java)

This code defines a **JPA entity** class named `State`, which represents a table named `state` in the database. The class is annotated with JPA annotations to map its fields to columns in the `state` table. Additionally, it uses **Lombok** annotations to generate boilerplate code such as constructors, getters, and setters. Let’s go through the important parts step by step:

### 1. **Package Declaration**
```java
package com.wsu.workorderproservice.model;
```
- This class is part of the `com.wsu.workorderproservice.model` package, indicating that it is part of the **model** or **entity layer** in the application. The model layer typically represents the structure of database tables as Java objects.

### 2. **JPA Annotations**
```java
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
```
- **`jakarta.persistence`**: This is part of the **Jakarta Persistence API (formerly JPA)**, which is used to map Java objects to database tables.
- **`@Entity`**: Marks the class as a JPA entity, meaning it is a representation of a table in the database.
- **`@Table(name = "state")`**: Specifies that this entity is mapped to the **`state`** table in the database.

### 3. **Lombok Annotations**
```java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
```
- **`@Getter`** and **`@Setter`**: Automatically generate the getter and setter methods for all fields in the class. This eliminates the need to manually define these methods.
- **`@NoArgsConstructor`**: Generates a no-argument constructor (i.e., `new State()`).
- **`@AllArgsConstructor`**: Generates a constructor with parameters for all fields (i.e., `new State(String code, String name)`).

### 4. **Entity Class**
```java
@Entity
@Table(name = "state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class State {
```
- The `State` class is marked as an entity, meaning it is mapped to the `state` table in the database. 
- The **`@Getter`**, **`@Setter`**, **`@NoArgsConstructor`**, and **`@AllArgsConstructor`** annotations from Lombok are used to automatically generate boilerplate code like getters, setters, and constructors.

### 5. **Fields and Column Mappings**
```java
@Id
@Column(name = "state_code")
private String code;

@Column(name = "state_name")
private String name;
```
- **`@Id`**: Marks the `code` field as the **primary key** of the entity. This field corresponds to the primary key column (`state_code`) in the `state` table.
  
- **`@Column(name = "state_code")`**: Maps the `code` field in the Java class to the `state_code` column in the `state` table. This tells JPA that the field `code` represents the primary key for the entity.
  
- **`@Column(name = "state_name")`**: Maps the `name` field to the `state_name` column in the database. This is a regular field representing the name of the state.

### How the Entity Works:
- **`State` class**: Represents a row in the `state` table in the database. Each instance of this class corresponds to a record in the table.
- **Fields**:
  - **`code`**: Represents the `state_code` column, which serves as the primary key.
  - **`name`**: Represents the `state_name` column, which holds the name of the state.
  
### Example of Creating an Instance:
The `@AllArgsConstructor` annotation generates a constructor that allows you to create a `State` object like this:

```java
State state = new State("CA", "California");
```

Or you can use the no-args constructor provided by `@NoArgsConstructor` and set the fields individually:

```java
State state = new State();
state.setCode("CA");
state.setName("California");
```

### Summary:
- The `State` class is an entity representing the `state` table in a database.
- It uses JPA annotations to map the fields `code` and `name` to the corresponding columns `state_code` and `state_name`.
- The class uses Lombok annotations to reduce boilerplate code by automatically generating getters, setters, and constructors.
- The `code` field is the primary key of the table, while `name` holds the state’s name.
