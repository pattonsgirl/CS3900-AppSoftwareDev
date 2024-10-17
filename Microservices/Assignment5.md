# Microservices - Assignment 5 

* Create /customers/{id} DELETE endpoint
* Create WorkOrderDTO & WorkOrderLineItemDTO and use them instead of entity model class

## Purpose / Objectives

- Understanding of JPA Entity relationship and mapping to Data Transfer Objects
- Understanding of DELETE endpoint including respective annotations

## Assignment Description

* Create /customers/{id} DELETE endpoint
  1. Add **deleteCustomer** method in the CustomerController.
     1. Pass customer id as a PathVariable.
     2. Call the CustomerService delete() method by passing the customerId.
     3. Return ResponseEntity with HTTP Status 200, a success message reading: "Successfully deleted customer", and don't bind data field when building ServiceResponseDTO.
  2. Add **delete** method in the CustomerService class.
     1. If the customer does not exist by customer id, then throw an InvalidRequestException.
     2. Inside of a try catch block, use the customerRespository to delete the customer by Id.
     3. If any exceptions occur, throw a new DatabaseErrorException inside of the catch block with the message: "Failed to delete customer".
     4. This method will be void, so there will be nothing returned after deleting the desired customer.
* Understand and complete the finishing touches for the WorkOrder **GET**, **CREATE** and **UPDATE** operations by completing the following steps.
  1. Create the workOrderDTO class with the same lombok annotations as the CustomerDTO class.
     1. Create a WorkOrderDTO class with the following fields:
        - Integer WorkOrderNumber
        - WorkOrderStatus statusCode
        - Date dateOrdered
        - Integer customerId
        - Date dateTimeScheduled
        - String technicianCode
        - Date dateTimeCompleted
        - Date dateTimeLastUpdated
        - Set<WorkOrderLineItemDTO> lineItems
    2. Create a WorkOrderLineItemDTO class with the following fields.
       - Integer workOrderNumber
       - String skuCode
       - Integer quantity
       - BigDecimal unitCost
       - Boolean taxable
       - BigDecimal tax
2. Convert the **addWorkOrder()** to have a WorkOrderDTO in the method parameters as a @RequestBody instead of a WorkOrder entity class in the controller. 
    1. Make sure the WorkOrderDTO passed in as a request body is passed to the WorkOrderService to process the request and add the Valid annotaion. 
3. Convert the **add()** method to have a WorkOrderDTO inside of the method parameters instead of the WorkOrder entity class in the service.
    1. Transform the WorkOrderDTO to a WorkOrder entity class in order to use the workOrderRepository to save the new entity.
    2. Convert the **add()** method to return a WorkOrderDTO instead of a WorkOrder entity model class. 
    3. Once the newly saved WorkOrder entity object is saved, map the returned WorkOrder object to a WorkOrderDTO object and return it.
4.  Convert the **updateWorkOrder()** method to have a WorkOrderDTO inside of the method parameters instead of the WorkOrder entity class in the service.
    1. Make sure the WorkOrderDTO passed in as a request body is passed to the WorkOrderService to process the request.
5. Convert the **update()** method to have a WorkOrderDTO inside of the method parameters instead of the WorkOrder entity class in the service.
    1. Transform the WorkOrderDTO to a WorkOrder entity class in order to use the workOrderRepository to save the new entity.
    2. Convert the **update()** method to return a WorkOrderDTO instead of a WorkOrder entity model class.
    3. Once the newly updated WorkOrder entity object is saved, map the returned WorkOrder object to a WorkOrderDTO object and return it.
6. Convert the **get()** method to return a WorkOrderDTO inside of the response instead of the WorkOrder entity class in the service.
    1. Make sure the WorkOrder and WorkOrderLineItem that is retrieved from the database are mapped to the corresponding DTOs before returning.
    2. Convert the return type of the **get()** method to WorkOrderDTO from WorkOrder. 

## Deliverable

* Push /customers/{id} DELETE endpoint into the Github repository.
* Push changes for WorkOrders endpoint into the Github repository. 


## Rubric

Microservices Assignment 5 Grading

Score:  / 5 points

* Create the **deleteCustomer()** method inside of the CustomerController with all the required steps listed above. (1 pt)
* Create the **delete()** method inside of the CustomerService with all the required steps listed above. (1 pt)
* Create the WorkOrderDTO & WorkOrderLineItemDTO class with the required fields listed above. (1 pt)
* Update WorkOrderController class to use WorkOrdeDTO as explained above in details. (1/2 pt)
* Create two methods in WorkOrderService class to convert entity to DTO and vice versa same like CustomService class. (1 pt)
* Update WorkOrderService class to use WorkOrdeDTO & WorkOrderLineItemDTO in request & response. (1/2 pt)

Feedback:
