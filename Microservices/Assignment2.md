 # Assignment#2

Create /customers GET endpoint and correct /products GET endpoint

## Purpose / Objectives

- Understanding of GET endpoint including respective annotations  
- Understanding of DTO class including lombok annotation  
- Understanding of Controller, Service and DAO repository layer.  
- Understanding of proper exception handling.

## Assignment Description

* Create the following below classes and a GET endpoint for customers. And allow users to search by customer name, address, email. \[/customers?search=\]  
  * CustomerController  
  * CustomerService  
  * CustomerDAO  
* Create CustomerDTO class with following fields and add required lombok annotations.  
  * id [Integer]  
  * firstName [String]  
  * lastName [String]  
  * addressLine1 [String]  
  * addressLine2 [String]  
  * city [String]  
  * state [String]  
  * zip [String]  
  * phone [String]  
  * email [String]  
  * latestWorkOrderStatus [String]  
  * lastUpdatedDate [Date]  
* Response format should be like below when HTTP status code is 200.
```
  {  
     "meta": {  
         "message": "Customers retrieved successfully."  
     },  
     "data": [  
         {  
             "id": 1,  
             "firstName": "Test",  
             "lastName": "User",  
             "addressLine1": "noneOfYour",  
             "addressLine2": "Bidness",  
             "city": "Dayton",  
             "state": "Ohio",  
             "zip": "45322",  
             "phone": "999-333-6677",  
             "email": "test@gmail.com",  
             "latestWorkOrderStatus": "Scheduled",  
             "lastUpdatedDate": "07/28/2024 10:20:00 AM"  
         }  
     ]  
  }
```
* Response format should be like below when HTTP status code is 500.
```
  {  
     "meta": {  
         "message": "Failed to retrieve customers.",  
         "errorMessage": "NullPointer Exception…….."  
     },  
     "Data": null  
  }
``` 
* Understand and correct the /products GET endpoint and response format should be like below.  
  200 HTTP Status Code
```
  {  
     "meta": {  
         "message": "Products retrieved successfully."  
     },  
     "data": [  
         {  
             "code": "PRODUCT100",  
             "name": "Product",  
             "unitCost":100.5,  
             "typeCode": "A",  
             "typeDescription": "Refrigerator",  
             "universalCode": "TEST",  
             "active": true,  
         }  
     ]  
  }
```

	500 HTTP Status Code  
```
{  
   "meta": {  
       "message": "Failed to retrieve products.",  
       "errorMessage": "NullPointer Exception…….."  
   },  
   "Data": null  
}
```
## Deliverable

* Push /customers GET endpoint into the Github repository.  
* Push fixes of /products GET endpoint into the Github repository.


## Rubric

- Create CustomerDTO class with proper field name & data type, and add required lombok annotations. (1pt)  
- Create Controller, Service and DAO class for Customer with required annotations. (1pt)  
- Create /customers GET endpoint to retrieve customers data from database, and return 200 & 500 HTTP status response in given format. (2 pt)  
- Fixes of /products GET endpoint to retrieve products from database, and return 200 & 500 HTTP status response in given format. (1 pt)
