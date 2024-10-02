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
2. Create the following classes and a GET endpoints for `/customers`.
   Allow users to search by customer name, address, email - ex. `[/customers?search=]`  
   * `CustomerController`  
   * `CustomerService`  
   * `CustomerDAO`  
4. Create `CustomerDTO` class with following fields and add required lombok annotations.  
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
   * dateLastUpdated [Date]
  
5. Meet the below repsonse formats for `/customers` depending on the HTTP response code:  

- When HTTP status code is **200**.
```
  {
    "meta": {
        "resultCount": 501,
        "message": "Customers retrieved successfully.",
        "pageCount": 251
    },
    "data": [
        {
            "id": 501,
            "firstName": "Pankaj",
            "lastName": "Kumar",
            "addressLine1": "123, XYZ",
            "addressLine2": "ABC Community",
            "city": "MIAMISBURG",
            "state": "OH",
            "zip": "12452",
            "phone": "8545656312",
            "email": "testpk12@gmail.com",
            "dateAdded": "2024-10-02 11:49:10 PM",
            "dateLastUpdated": "2024-10-02 11:49:10 PM",
            "latestWorkOrderStatus": null
        },
        {
            "id": 256,
            "firstName": "Dottie",
            "lastName": "Hellickson",
            "addressLine1": "67 E Chestnut Hill Rd",
            "addressLine2": "",
            "city": "Seattle",
            "state": "WA",
            "zip": "98133",
            "phone": "2065406076",
            "email": "dottie@hellickson.org",
            "dateAdded": "2024-10-01 07:19:28 PM",
            "dateLastUpdated": "2024-10-01 07:19:28 PM",
            "latestWorkOrderStatus": "Completed"
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
            "code": "348951",
            "name": "Dishwasher Installation",
            "unitCost": 150,
            "typeCode": "P",
            "universalProductCode": "",
            "active": true
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
