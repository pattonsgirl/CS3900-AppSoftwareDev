# Testing - Assignment 2 - Service Tests

Create Service classes MockitoJunit test cases.

## Purpose / Objectives

- Understanding of uses for ExtendWith & MockitoExtension for registering Test Service class.  
- Understanding of Mock & Spy annotations for declaring Spring Context bean class.  
- Understanding of BeforeEach, & Test annotations for method declaration and its executions.  
- Understanding of handling all possible test cases for service class methods.

## Assignment Description

* Create CustomerServiceTest class for CustomerService and add all test methods for save, update & get methods. Make sure all JUnit test cases should pass.  
  * save method \- cover JUnit test cases for success and failure cases (when exception occurs).  
  * update method \- cover JUnit test cases for success, failure cases (when exception occurs, customer id not found).  
  * get method \- cover JUnit test cases for success, failure cases (when exception occurs),  data not found based on given criteria. And verify the response when data is returned without any exceptions.  
* Continue WorkOrderServiceTest class remaining methods test cases. Make sure all JUnit test cases should pass.  
  * saveLineItem method \- cover JUnit test cases for success and failure cases (when exception occurs, workOrder id not found).  
  * get method \- cover JUnit test cases for success, failure cases (when exception occurs),  data not found based on given criteria. And verify the response when data is returned without any exceptions.  
* Fixes in StateServiceTest class for state get method. Make sure all JUnit test cases should pass.  
  * Fix test cases for the get method to confirm it’s handling success and failure cases (when exception occurs), data not found. And verify the returned data when there is no exception.  
    

## Deliverable

* Push CustomerServiceTest class into the Github repository.  
* Push new JUnit test cases for WorkOrder service class methods into the Github repository.  
* Push fixes of StateServiceTest class into the Github repository.

## Rubric

Testing Assignment 2 Grading

Score:  / 5 points

- Create CustomerServiceTest class for CustomerService class, and add all test methods for save, update & get methods. Make sure all JUnit test cases should pass. (2pt)  
- Finish WorkOrderServiceTest class remaining methods test cases. Make sure all JUnit test cases should pass. (2pt)  
- Fixes in StateServiceTest class for state get method. Make sure all JUnit test cases should pass. (1pt)

Feedback: 