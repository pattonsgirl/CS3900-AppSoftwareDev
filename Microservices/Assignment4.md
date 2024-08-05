 # Assignment\#4

Create /customers/{customerId} PUT endpoint and complete /workOrders POST endpoint

\#\# Purpose / Objectives

- Understanding of PUT endpoint including respective annotations  
- Understanding of Entity class including lombok & Jakarta Persistence annotations.  
- Understanding of JPA Repository.  
- Understanding of Bean Validation.

\#\# Assignment Description

* Create /customers/{customerId} PUT endpoint and add proper bean validation.  
* The Request Body should be like below.  
   {  
             "firstName": "Test",  
             "lastName": "User",  
             "addressLine1": "noneOfYour",  
             "addressLine2": "Bidness",  
             "city": "Dayton",  
             "state": "Ohio",  
             "zip": "45322",  
             "phone": "999-333-6677",  
             "email": "test@gmail.com"  
   }  
    
* Response format should be like below when HTTP status code is 200\.  
  {  
     "meta": {  
         "message": "Customer updated successfully."  
     },  
     "data": {  
             "id": 1,  
             "firstName": "Test",  
             "lastName": "User",  
             "addressLine1": "noneOfYour",  
             "addressLine2": "Bidness",  
             "city": "Dayton",  
             "state": "Ohio",  
             "zip": "45322",  
             "phone": "999-333-6677",  
             "email": "test@gmail.com"  
         } 
  }  
* Response format should be like below when HTTP status code is 500\.  
  {  
     "meta": {  
         "message": "Failed to update customer.",  
         "errorMessage": "NullPointer Exception…….."  
     },  
     "Data": null  
  }

* Response format should be like below when HTTP Status code is 404 (when customer id not found in database)\.
  {  
     "meta": {  
         "message": "Invalid customer id." 
     },  
     "Data": null  
  }
* Response format should be like below when HTTP Status code is 400\.  
  {  
      "meta": {  
          "message": "Validation Error"  
      },  
      "data": {  
          "entity": "customerDTO",  
          "errors": \[  
              {  
                  "field": "firstName",  
                  "rejectedValue": null,  
                  "message": "Customer first name must not be null or blank",  
                  "errorCode": "NOT\_BLANK"  
              },  
              {  
                  "field": "email",  
                  "rejectedValue": null,  
                  "message": "Customer email must not be null or blank",  
                  "errorCode": "NOT\_BLANK"  
              }  
          \]  
      }  
  }  
    
* Finish /workOrders POST endpoint and return response in expected format.
* 
\#\# Deliverable

* Push /customers/{customerId} PUT endpoint into the Github repository.  
* Push remaining changes of /workOrders POST endpoint into the Github repository.

\#\# Bonus Feature  
	Create /customers/{customerID} DELETE endpoint to remove customer data from database, if it’s not associated with any work order.  
\#\# Rubric

- Create /customers PUT endpoint to update customer data in database, and return 200, 400 & 500 HTTP status response in given format. (2 pt)
- Handle exception when customer doesn't exists then return 404 with valid message. (1 pt)  
- Complete remaining changes of /workOrders POST endpoint to save work order in database, and return 200, 400 & 500 HTTP status response in given format. (2 pt)
