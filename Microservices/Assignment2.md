# Microservices - Assignment 2 - Build GET Endpoints

Create /customers GET endpoint and correct /products GET endpoint

## Purpose / Objectives

- Understanding of GET endpoint including respective annotations  
- Understanding of DTO class including lombok annotation  
- Understanding of Controller, Service and DAO repository layer.  
- Understanding of proper exception handling.

## Assignment Description

1. Clone the Assignment 2 GitHub repository using the below command  in a terminal.  
   * git clone \<GHrepo-URI\> 
2. Create the following classes and a GET endpoints for `/customers`. Allow users to search by customer name, address, email - ex. `[/customers?search=]`  
   * `CustomerController`  
   * `CustomerService`  
   * `CustomerDAO`  
3. Create `CustomerDTO` class with following fields and add required lombok annotations.  
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
  
4. Meet the below repsonse formats for `/customers` depending on the HTTP response code:  

- When HTTP status code is **200**.
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
- When HTTP status code is **500**.
```
  {  
     "meta": {  
         "message": "Failed to retrieve customers.",  
         "errorMessage": "NullPointer Exception…….."  
     },  
     "Data": null  
  }
``` 

5. **Understand and correct** the **/products** GET endpoint code such that it the **fixed** reponse format looks like the below examples:  

- HTTP Status Code of **200**
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

- HTTP Status Code of **500**
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

Push your changes to your Assignment 2 GitHub repository.  Changes should include:
* `/customers` GET endpoint  
* `/products` fixed GET endpoint

## Rubric

Microservices Assignment 2 Grading

Score:  / 5 points

- Create CustomerDTO class with proper field name & data type, and add required lombok annotations. (1pt)  
- Create Controller, Service and DAO class for Customer with required annotations. (1pt)  
- Create /customers GET endpoint to retrieve customers data from database, and return 200 & 500 HTTP status response in given format. (2 pt)  
- Fixes of /products GET endpoint to retrieve products from database, and return 200 & 500 HTTP status response in given format. (1 pt)

Feedback: 
