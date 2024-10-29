package com.wsu.workorderproservice.controller;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.dto.WorkOrderDTO;
import com.wsu.workorderproservice.service.WorkOrderService;
import jakarta.validation.Valid;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workOrders")
public class WorkOrderController {
    
    private final WorkOrderService workOrderService;

    /**
     * This endpoint used to get details of WorkOrder based on WorkOrderNumber
     * @param workOrderNumber - it's used to get WorkOrder details based on WorkOrderNumber
     * @return - ServiceResponseDTO which contains details of WorkOrder
     */
    @GetMapping(value = "{workOrderNumber}")
    public ResponseEntity<ServiceResponseDTO> getWorkOrder(@PathVariable Integer workOrderNumber) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Work Order retrieved successfully."))
                .data(workOrderService.get(workOrderNumber)).build(), HttpStatus.OK);
    }

    /**
     * This endpoint used for add new WorkOrder
     * @param workOrderDTO - WorkOrderDTO
     * @return - ServiceResponseDTO which include WorkOrder saved entity
     */
    @PostMapping
    public ResponseEntity<ServiceResponseDTO> addWorkOrder(@RequestBody @Valid WorkOrderDTO workOrderDTO) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "WorkOrder added successfully."))
                .data(workOrderService.add(workOrderDTO)).build(), HttpStatus.CREATED);
    }

    /**
     * This endpoint used for update existing WorkOrder
     * @param workOrderNumber - WorkOrderNumber used to update existing WorkOrder
     * @param workOrderDTO - WorkOrderDTO payload contains updated WorkOrder
     * @return - ServiceResponseDTO which include WorkOrder updated entity model class.
     */
    @PutMapping(value = "{workOrderNumber}")
    public ResponseEntity<ServiceResponseDTO> updateWorkOrder(@PathVariable Integer workOrderNumber, @RequestBody @Valid WorkOrderDTO workOrderDTO) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "WorkOrder updated successfully."))
                .data(workOrderService.update(workOrderNumber, workOrderDTO)).build(), HttpStatus.OK);
    }
}
