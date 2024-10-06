
# Building Endpoints with SpringBoot

## What is SpringBoot?

## How are SpringBoot applications organized?

The module instructors are going to organize the code **by layer** not by feature.  If it was by feature, we would see folders called `technician` with technician related layers inside.  Instead most common practice is to organize by layer, and have classes that focus on topics, like technician.

![Structure by Layer or Feature?](https://raw.githubusercontent.com/danvega/code-structure/refs/heads/main/package-by-layer-feature.png)

![SpringBoot Architecture](https://www.interviewbit.com/blog/wp-content/uploads/2022/06/Spring-Boot-Workflow-Architecture-800x480.png)

# What's Happening in the Code?

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


