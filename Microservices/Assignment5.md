  # Assignment\#5

Create /workOrders/{workOrderId}/lineItems POST endpoint and complete /workOrders PUT endpoint changes

\#\# Purpose / Objectives

- Understanding of JPA Entity relationship  
- Understanding of subresource REST API design pattern.

\#\# Assignment Description

* Create /workOrders/{workOrderId}/lineItems POST endpoint and add proper bean validation.  
* The Request Body should be like below.
  ```
   {  
             "code": "PRODUCT101",  
             "quantity": 2,  
             "unitCost": 99.5,  
             "taxable": true,  
             "tax": 10  
   }
  ```
    
* Response format should be like below when HTTP status code is 201\.
  ```
  {  
     "meta": {  
         "message": "Line item added successfully."  
     },  
     "data": {  
             "code": "PRODUCT101",  
             "quantity": 2,  
             "unitCost": 99.5,  
             "taxable": true,  
             "tax": 10  
   }  
  }
  ```
* Response format should be like below when HTTP status code is 500\.
  ```
  {  
     "meta": {  
         "message": "Failed to add workorder line item.",  
         "errorMessage": "NullPointer Exception…….."  
     },  
     "Data": null  
  }
  ```
* Response format should be like below when HTTP Status code is 400\.
  ```
  {  
      "meta": {  
          "message": "Validation Error"  
      },  
      "data": {  
          "entity": "lineItemDTO",  
          "errors": \[  
              {  
                  "field": "code",  
                  "rejectedValue": null,  
                  "message": "Product Code  must not be null or blank",  
                  "errorCode": "NOT\_BLANK"  
              }  
          \]  
      }  
  }
  ```
    
* Finish /workOrders/{workOrderId} PUT endpoint remaining changes and return response in expected format.


\#\# Deliverable

* Push /workOrders/{workOrderId}/lineItem POST endpoint into the Github repository.  
* Push remaining changes of /workOrders/{workOrderId} PUT endpoint into the Github repository.


\#\# Rubric

- Create /workOrders/{workOrderId}/{lineItem} POST endpoint to add new line item for work order in database, and return 201, 400 & 500 HTTP status response in given format. (2 pt)  
- Handle exception when workOrder doesn't exists then return 404 with a valid message. (1 pt)  
- Complete remaining changes of /workOrders/{workOrderId} PUT endpoint to update workorder details in database, and return 200, 400 & 500 HTTP status response in given format. (2 pt)
