# Assignment\#8

Create the Karate Test Suite for Endpoints.

\#\# Purpose / Objectives

- Karate API Testing  
- Contract Verification  
- Integration Testing

\#\# Assignment Description

* Create a WorkOrder.feature class in the features folder of the test directory.   
* Create the following scenarios to perform a GET, POST, & PUT for WorkOrders.  
  * Create a GET request to retrieve a workOrder.  
    * Confirm the following fields from the GET response:  
      * WorkOrderNumber  
      * CustomerId  
      * TechnicianCode  
      * Confirm the response status is 200\.  
  * Create a POST request with all the required fields for a workOrder.  
    * Confirm the following fields from the POST response:  
      * WorkOrderNumber  
      * CustomerId  
      * TechnicianCode  
      * Confirm the response status is 201  
* Create a PUT request with updated ‘customerId’ and ‘technicianCode’ fields for a workOrder.  
  * Confirm the following fields from the PUT response:  
    * CustomerId  
    * TechnicianCode  
    * Confirm the response status is 204  
* Create a Technician.feature class in the features folder of the test directory.   
* Create the following scenarios to perform a GET request for a Technician.  
  * Create a GET request to retrieve a technician.  
    * Confirm the following fields from the GET response:  
      * TechnicianCode  
      * TechnicianFirstName  
      * TechnicianLastName  
      * Confirm the response status is 200\.  
* Create a Product.feature in the features folder of the test directory.   
  * Create a GET request to retrieve a product.  
    * Confirm the following fields from the GET response:  
      * Quantity  
      * UnitCost  
      * Taxable  
      * Confirm the response status is 200\.

    

\#\# Deliverable

* Push WorkOrder test suite into the Github repository.  
* Push Technician GET endpoint karate test suite into the Github repository.  
* Push fixes of Product GET endpoint Karate test suite into the Github repository.

\#\# Rubric

- Create a new Karate test suite for WorkOrder POST, PUT & GET endpoints. (3pt)  
- Create a new Karate test suite for Technician GET endpoint. (1pt)  
- Fixes in existing Karate test suite for product GET endpoint. (1pt)  
- 