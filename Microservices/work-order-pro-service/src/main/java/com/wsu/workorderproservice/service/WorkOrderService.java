package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.WorkOrderDTO;
import com.wsu.workorderproservice.dto.WorkOrderLineItemDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.model.WorkOrder;
import com.wsu.workorderproservice.model.WorkOrderLineItem;
import com.wsu.workorderproservice.repository.WorkOrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    /**
     * This method used for retrieve the WorkOrder details by workOrderNumber
     * @param workOrderNumber - it's used to get WorkOrder details
     * @return - WorkOrder details.
     */
    public WorkOrderDTO get(Integer workOrderNumber) {
        Optional<WorkOrder> workOrder = workOrderRepository.findById(workOrderNumber);
        if (workOrder.isEmpty()) {
            throw new InvalidRequestException("Invalid WorkOrder number");
        }
        try {
            return mapToDTO(workOrderRepository.findById(workOrderNumber).orElse(null));
        } catch (Exception e) {
            log.error("Failed to retrieve WorkOrder details. workOrderNumber:{}, Exception:{}", workOrderNumber, e);
            throw new DatabaseErrorException("Failed to retrieve WorkOrder details.", e);
        }
    }

    /**
     * This method used for add new WorkOrder with line items if any
     * @param workOrderDTO - WorkOrderDTO DTO class.
     * @return - returns saved WorkOrder in DTO class
     */
    @Transactional(rollbackOn = Exception.class)
    public WorkOrderDTO add(WorkOrderDTO workOrderDTO) {
        try {
            WorkOrder workOrder = mapToEntity(workOrderDTO);
            Set<WorkOrderLineItem> lineItems = workOrder.getLineItems();
            workOrder.setLineItems(null);
            WorkOrder workOrderResp = workOrderRepository.save(workOrder);
            lineItems.forEach(lineItem -> lineItem.setWorkOrderNumber(workOrderResp.getWorkOrderNumber()));
            workOrderResp.setLineItems(lineItems);
            return mapToDTO(workOrderRepository.save(workOrderResp));
        } catch (Exception e) {
            log.error("Failed to add WorkOrder. Exception: ", e);
            throw new DatabaseErrorException("Failed to add new WorkOrder.", e);
        }
    }

    /**
     * This method used for update the existing WorkOrder based on given WorkOrder number
     * @param workOrderNumber - primary key that's used for update existing WorkOrder
     * @param workOrderDTO - payload that contains updated WorkOrder
     * @return - Updated WorkOrderDTO
     */
    @Transactional(rollbackOn = Exception.class)
    public WorkOrderDTO update(Integer workOrderNumber, WorkOrderDTO workOrderDTO) {
        Optional<WorkOrder> workOrderResp = workOrderRepository.findById(workOrderNumber);
        if (workOrderResp.isEmpty()) {
            throw new InvalidRequestException("Invalid WorkOrder number");
        }
        try {
            WorkOrder workOrder = mapToEntity(workOrderDTO);
            workOrder.setWorkOrderNumber(workOrderResp.get().getWorkOrderNumber());
            workOrder.setDateTimeLastUpdated(new Date());
            if (!CollectionUtils.isEmpty(workOrder.getLineItems())) {
                workOrder.getLineItems().forEach(lineItem -> lineItem.setWorkOrderNumber(workOrder.getWorkOrderNumber()));
            }
            return mapToDTO(workOrderRepository.save(workOrder));
        } catch (Exception e) {
            log.error("Failed to update WorkOrder. workOrderNumber:{}, Exception:{}", workOrderNumber, e);
            throw new DatabaseErrorException("Failed to update WorkOrder.", e);
        }
    }

    /**
     * This method used to map WorkOrderDTO class to
     * @param workOrderDTO
     * @return
     */
    private WorkOrder mapToEntity(WorkOrderDTO workOrderDTO) {
        WorkOrder workOrder = WorkOrder.builder().workOrderNumber(workOrderDTO.getWorkOrderNumber())
                .statusCode(workOrderDTO.getStatusCode()).dateOrdered(workOrderDTO.getDateOrdered())
                .customerId(workOrderDTO.getCustomerId()).dateTimeScheduled(workOrderDTO.getDateTimeScheduled())
                .technicianCode(workOrderDTO.getTechnicianCode()).dateTimeCompleted(workOrderDTO.getDateTimeCompleted())
                .dateTimeLastUpdated(workOrderDTO.getDateTimeLastUpdated()).build();
        if (!CollectionUtils.isEmpty(workOrderDTO.getLineItems()))  {
            workOrder.setLineItems(workOrderDTO.getLineItems().stream().map(lineItemDTO -> WorkOrderLineItem
                    .builder().workOrderNumber(lineItemDTO.getWorkOrderNumber())
                    .skuCode(lineItemDTO.getSkuCode()).quantity(lineItemDTO.getQuantity()).tax(lineItemDTO.getTax())
                    .unitCost(lineItemDTO.getUnitCost()).taxable(lineItemDTO.getTaxable()).build()).collect(Collectors.toSet()));
        }
        return workOrder;
    }

    /**
     * This method used to map WorkOrder entity model class to DTO
     * @param workOrder - entity model class
     * @return - DTO class
     */
    private WorkOrderDTO mapToDTO(WorkOrder workOrder) {
        if (workOrder == null) {
            return null;
        }
        WorkOrderDTO workOrderDTO = WorkOrderDTO.builder().workOrderNumber(workOrder.getWorkOrderNumber())
                .statusCode(workOrder.getStatusCode()).dateOrdered(workOrder.getDateOrdered())
                .customerId(workOrder.getCustomerId()).dateTimeScheduled(workOrder.getDateTimeScheduled())
                .technicianCode(workOrder.getTechnicianCode()).dateTimeCompleted(workOrder.getDateTimeCompleted())
                .dateTimeLastUpdated(workOrder.getDateTimeLastUpdated()).build();
        if (!CollectionUtils.isEmpty(workOrder.getLineItems()))  {
            workOrderDTO.setLineItems(workOrder.getLineItems().stream().map(lineItem -> WorkOrderLineItemDTO
                    .builder().workOrderNumber(lineItem.getWorkOrderNumber())
                    .skuCode(lineItem.getSkuCode()).quantity(lineItem.getQuantity()).tax(lineItem.getTax())
                    .unitCost(lineItem.getUnitCost()).taxable(lineItem.getTaxable()).build()).collect(Collectors.toSet()));
        }
        return workOrderDTO;
    }
}
