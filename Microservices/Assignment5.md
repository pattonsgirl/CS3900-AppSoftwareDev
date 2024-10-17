# Microservices - Assignment 5 - Finalizing Endpoints

Create /workOrders/{workOrderId}/lineItems POST endpoint and complete /workOrders PUT endpoint changes

## Purpose / Objectives

- Understanding of JPA Entity relationship and mapping to Data Transfer Objects
- Understanding of DELETE endpoint including respective annotations  
- Understanding of Bean Validation.

## Assignment Description

* Create /customers/{customerId} DELETE endpoint
  1. Add **deleteCustomers** method in the CustomerController.
     1. Pass customer id as a PathVariable.
     2. Call the CustomerService delete() method by passing the customerId.
     3. Return ResponseEntity with HTTP Status 200, a success message reading: "Successfully deleted customer", and an empty data field building ServiceResponseDTO.
  2. Add **delete** method in the Customer Service class.
     1. If the customer does not exist by customerId, then throw an InvalidRequestException.
     2. Inside of a try catch block, use the customerRespository to delete the customer by Id.
     3. If any exceptions occur, throw a new database exception inside of the catch block with the message: "Failed to delete customer".
     4. This method will be void, so there will be nothing returned after deleting the desired customer.
* Complete the finishing touches for the WorkOrder **CREATE** and **UPDATE** operations by completing the following steps.
  1. Create the workOrderDTO class with the same lombok annotations as the CustomerDTO class.
     1. Create a WorkOrderDTO class with the following fields:
        - Integer WorkOrderNumber
        - WorkOrderStatus statusCode
        - Integer customerId
        - String technicianCode
        - List<LineItems> lineItems
        - Date dateTimeCompleted
        - Date dateTimeLastUpdated
        - Date dateTimeScheduled
  2. Convert the **addWorkOrder()** to have a WorkOrderDTO in the method parameters as a @RequestBody instead of a WorkOrderPro entity class in the controller. 
       1. Make sure the WorkOrderDTO passed in as a request body is passed to the WorkOrderService to process the request. 
  3. Convert the **add()** method to have a WorkOrderDTO inside of the method parameters instead of the WorkOrderPro entity class in the service.
       1. Transform the WorkOrderDTO to a WorkOrder entity class in order to use the workOrderRepository to save the new entity.
       2. Convert the **add()** method to return a WorkOrderDTO instead of a WorkOrder entity model class. 
       3. Once the newly saved WorkOrder entity object is saved, map the returned WorkOrder object to a WorkOrderDTO object and return it.
  4.  Convert the **updateWorkOrder()** method to have a WorkOrderDTO inside of the method parameters instead of the WorkOrderPro entity class in the service.
       1. Make sure the WorkOrderDTO passed in as a request body is passed to the WorkOrderService to process the request.
  5. Convert the **update()** method to have a WorkOrderDTO inside of the method parameters instead of the WorkOrderPro entity class in the service.
       1. Transform the WorkOrderDTO to a WorkOrder entity class in order to use the workOrderRepository to save the new entity.
       2. Convert the **update()** method to return a WorkOrderDTO instead of a WorkOrder entity model class.
       3. Once the newly saved WorkOrder entity object is saved, map the returned WorkOrder object to a WorkOrderDTO object and return it.  


## Deliverable

* Push all changes to Github.
* Create the **deleteCustomers()** method inside of the Customer controller with all the required steps listed above. (1 pt)
* Create the **delete()** method inside of the Customer service with all the required steps listed above. (1 pt)   
* Convert the **addWorkOrder()** method inside of the WorkOrderController to use a WorkOrderDTO instead of a WorkOrder entity model object. (1 pt)
* Create the WorkOrderDTO class with the required fields listed above. (1 pt) 
* Convert the **add()** method inside of the WorkOrderService to use a WorkOrderDTO instead of a WorkOrder entity model object. (1 pt)
* Convert the **updateWorkOrder()** method inside of the WorkOrderController to use a WorkOrderDTO instead of a WorkOrder entity model object. (1 pt)
* Convert the **add()** method inside of the WorkOrderService to use a WorkOrderDTO instead of a WorkOrder entity model object. (1 pt)


## Rubric

Microservices Assignment 5 Grading

Score:  / 5 points

- Create /workOrders/{workOrderId}/{lineItem} POST endpoint to add new line item for work order in database, and return 201, 400 & 500 HTTP status response in given format. (2 pt)  
- Handle exception when workOrder doesn't exists then return 404 with a valid message. (1 pt)  
- Complete remaining changes of /workOrders/{workOrderId} PUT endpoint to update workorder details in database, and return 200, 400 & 500 HTTP status response in given format. (2 pt)

Feedback:
