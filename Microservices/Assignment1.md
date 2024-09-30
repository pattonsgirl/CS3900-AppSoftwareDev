# Microservices - Assignment 1 - GET Endpoint Response Test

Students are expected to demonstrate the understanding of running SpringBoot application in local dev container using VSCode and will be able call their first GET endpoint (healthCheck). Quiz questions will be given to determine basic understanding of microservice and related concepts.

## Purpose / Objectives

- Microservice Architecture  
- Spring MVC Framework and Spring JPA  
- REST API Design Pattern  
- HTTP Status code  
- Setup dev container and VSCode 


## Assignment Description details.

1. Clone the Assignment 1 GitHub repository using the below command  in a terminal.  
   * git clone \<GHrepo-URI\>  
2. Open this Project in your Visual Studio Code.
   * Use `code .` if you cloned to WSL2 - this will open the current working directory in VS Code. 
3. Run the application using WorkOrderProDockerRunConfig on VsCode’s Run & Debug tab:   
   * Refer to this document for running applications in VSCode using Docker container: TODO: add resource  
   * Upload a screenshot of the running application in VSCode to the Assignment 1 GitHub repository in a file named `README.md`.  
4. Once the application started, then call healthCheck GET endpoint and take a screenshot of the result:   
   * `curl -X GET http://localhost:8080/work-order-pro-service/healthcheck` (in WSL2)   
   * Add a screenshot of the network call to the Assignment 1 GitHub repository in the file named `README.md`.  

## Deliverable

Submit work to the Microserivces Assignment 1 GitHub repository  
Your `README.md` file should contain: 
 * Screenshot of running application in local  
 * Screenshot of health check GET endpoint response  

## Rubric

Microservices Assignment 1 Grading

Score:  / 5 points

- Open application in VSCode and configure docker dev container (2 pt)  
- Able to run application successfully in local and able to access health check GET endpoint (1 pts)  
- Pre Class Knowledge Check Quiz Score (2 pts)

Feedback: 
