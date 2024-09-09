# Microservices - Assignment 1 - GET Endpoint Response Test

Students are expected to demonstrate the understanding of running SpringBoot application in local dev container using VSCode and will be able call their first GET endpoint (healthCheck). Quiz questions will be given to determine basic understanding of microservice and related concepts.

## Purpose / Objectives

- Microservice Architecture  
- Spring MVC Framework and Spring JPA  
- REST API Design Pattern  
- HTTP Status code  
- Setup dev container and VSCode 


## Assignment Description details.

* Clone the work-order-pro-service from the github repository using the below command  in a terminal.  
  * git clone \<GithubRepoURI\>  
* Open this Project in your Visual Studio Code.  
* Run the application using WorkOrderProDockerRunConfig on VsCode’s Run & Debug tab:   
  * Refer to this document for running applications in VSCode using Docker container: [https://docs.google.com/document/d/1mTbcP4V2jsSTKgHKeGGG4IxMOt6xstEinGopJi-cob0/edit](https://docs.google.com/document/d/1mTbcP4V2jsSTKgHKeGGG4IxMOt6xstEinGopJi-cob0/edit)  
  * Upload a screenshot of the running application in VSCode to the github readme.md file.  
* Once the application started, then call healthCheck GET endpoint and take a screenshot of the result:   
  *  curl \-X GET [http://localhost:8080/work-order-pro-service/healthcheck](http://localhost:8080/work-order-pro-service/healthcheck) (in a terminal)   
  * Add a screenshot of the network call to the readMe file.  
* (Pre-class) Quiz assignment on these topics (10 single & multiple choice questions).

## Deliverable

Submit work to GitHub repo  
Add to README: 

* Screenshot of running application in local  
* Screenshot of health check GET endpoint response  
* Complete the Quiz in Pilot

## Rubric

Microservices Assignment 1 Grading

Score:  / 5 points

- Open application in VSCode and configure docker dev container (2 pt)  
- Able to run application successfully in local and able to access health check GET endpoint (1 pts)  
- Assignment question’s answers (quiz) (2 pts)

Feedback: 
