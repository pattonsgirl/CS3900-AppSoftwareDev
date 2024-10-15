# Microservices - Assignment 4 - Build PUT Endpoints

Create `/customers/{customerId}` PUT endpoint

## Purpose / Objectives

- Understanding of PUT endpoint including respective annotations  
- Understanding of Entity class including lombok & Jakarta Persistence annotations.  
- Understanding of JPA Repository.  
- Understanding of Bean Validation.

## Assignment Description

* Create `/customers/{customerId}` PUT endpoint and add Bean Validation.
  1. Add **updateCustomer** method in CustomerController.
     1. Pass customer id as PathVariable.
     2. Apply Bean Validation by using @Valid annotation.
     3. Call CustomerService update() method by passing customer Id & CustomerDTO.
     4. Return ResponseEntity with HTTP Status 200 and updated CustomerDTO by building ServiceResponseDTO.
  2. Add **update** method in Customer Service class.
     1. If Customer does not exist by customer id then throw InvalidRequest Exception. (Call existsById method from Repository)
     2. Add try-catch block (throw DatabaseErrorException when any exception occurs).
     3. Convert CustomerDTO to Customer entity model class.
     4. Set customer id on Customer entity model class.
     5. Call CustomerRepository save() method by passing customer entity model class.
     6. Convert Customer entity model class returned by CustomerRespository's save method in CustomerDTO class.
* The Request Body should be like below.
```
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
```
    
* Response format should be like below when HTTP status code is 200\.
```
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
```
* Response format should be like below when HTTP status code is 500\.  
```
  {  
     "meta": {  
         "message": "Failed to update customer.",  
         "errorMessage": "NullPointer Exception…….."  
     },  
     "Data": null  
  }
```

* Response format should be like below when HTTP Status code is 404 (when customer id not found in database)\.
```
  {  
     "meta": {  
         "message": "Invalid customer id." 
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
          "entity": "customerDTO",  
          "errors": [  
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
          ]  
      }  
  }
```

## Deliverable

* Push /customers/{customerId} PUT endpoint into the Github repository.  
 
## Rubric

Microservices Assignment 4 Grading

Score:  / 5 points

- Add **updateCustomer** method in CustomerController class as explained above in details . (2 pt)
- Add **update** method in CustomerService class as explained above in details. (3 pt)

Feedback: 
