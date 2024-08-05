  # Assignment#3

Create /customers POST endpoint and correct /states GET endpoint

\#\# Purpose / Objectives

- Understanding of POST endpoint including respective annotations  
- Understanding of Entity class including lombok & Jakarta Persistence annotations.  
- Understanding of JPA Repository.  
- Understanding of Bean Validation.

\#\# Assignment Description

* Create /customers POST endpoint and add proper bean validation.  
* Create Customer entity model class and add all required Jakarta Persistence annotations.  
* Create CustomerRepository interface and extend JPARepository for JPA implementation.  
* Add Bean validations on CustomerDTO class to make the following fields required and apply format validation on email & phone  
  * firstName \[Not Null, max (20)\]  
  * lastName \[Not Null, max (25)\]  
  * addressLine1 \[Not Null, max (50)\]  
  * addressLine2 \[Not Null, max (50)\]  
  * city \[Not Null, max (25)\]  
  * state \[Not Null, max (2)\]  
  * zip \[Not Null, max (5)\]  
  * phone \[Not Null, max (10)\] \- \[allow only numbers with valid phone format\]  
  * email \[Not Null, max (100)\] \- \[allow only valid email format\]  
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
         "message": "Customer created successfully."  
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
         "message": "Failed to create customer.",  
         "errorMessage": "NullPointer Exception…….."  
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
    
* Understand and correct the /states GET endpoint and response format should be like below.  
  200 HTTP Status Code  
  {  
     "meta": {  
         "message": "States retrieved successfully."  
     },  
     "data": \[  
         {  
             "code": "OH",  
             "name": "Ohio"  
         }  
     \]  
  }

	500 HTTP Status Code  
{  
   "meta": {  
       "message": "Failed to retrieve states.",  
       "errorMessage": "Arithmetic Exception…….."  
   },  
   "Data": null  
}  
\#\# Deliverable

* Push /customers POST endpoint into the Github repository.  
* Push fixes of /states GET endpoint into the Github repository.

\#\# Rubric

- Add required fields validation and format validation on CustomerDTO class. (1pt)  
- Create Customer entity model class with all required Jakarta persistence annotations and create CustomerRepository for the implementation. (1pt)  
- Create /customers POST endpoint to save customer data in database, and return 200, 400 & 500 HTTP status response in given format. (2 pt)  
- Fixes of /states GET endpoint to retrieve states from database, and return 200 & 500 HTTP status response in given format. (1 pt)
