# Assignment\#6

Create Controller classes WebMVCTest 

\#\# Purpose / Objectives

- Understanding of WebMvcTest for Controller class.  
- Understanding of MockMvc, MockBean, Mock & Spy annotations for declaring Spring Context bean class.  
- Understanding of BeforeEach, & Test annotations for method declaration and its executions.  
- Understanding of handling all possible test cases for controller class endpoints.

\#\# Assignment Description

* Create CustomerControllerTest class for CustomerController and add all test methods for POST, PUT & GET endpoints. Make sure all JUnit test cases should pass.  
  * POST endpoint \- cover JUnit test cases for 200, 400, 404 & 405 HTTP Status and verify response using ResponseBodyMatcher.toContains() method when status code is 200\.  
  * PUT endpoint \- cover JUnit test cases for 200, 400, 404 & 405 HTTP Status and verify response using ResponseBodyMatcher.toContains() method when status code is 200  
  * GET endpoint \- cover JUnit test cases for 200, 404 & 405 HTTP Status and verify response using ResponseBodyMatcher.toContains() method when status code is 200  
* Continue WorkOrderControllerTest class remaining endpoints test cases. Make sure all JUnit test cases should pass.  
  * POST endpoint (line item) \- cover JUnit test cases for 200, 400, 404 & 405 HTTP Status and verify response using ResponseBodyMatcher.toContains() method when status code is 200\.  
  * GET endpoint \- cover JUnit test cases for 200, 404 & 405 HTTP Status and verify response using ResponseBodyMatcher.toContains() method when status code is 200  
* Fixes in StateControllerTest class for state GET endpoint. Make sure all JUnit test cases should pass.  
  * Fix test cases for GET endpoint to confirm it’s handle 200, 404 & 405 HTTP Status code and verify response when status code is 200\.  
    

\#\# Deliverable

* Push CustomerControllerTest class into the Github repository.  
* Push new JUnit test cases for WorkOrder endpoints into the Github repository.  
* Push fixes of StateControllerTest class into the Github repository.

\#\# Rubric

- Create CustomerControllerTest class for CustomerController class, and add all test methods for POST, PUT & GET endpoints. Make sure all JUnit test cases should pass. (2pt)  
- Finish WorkOrderControllerTest class remaining endpoints test cases. Make sure all JUnit test cases should pass. (2pt)  
- Fixes in StateControllerTest class for state GET endpoint. Make sure all JUnit test cases should pass. (1pt)