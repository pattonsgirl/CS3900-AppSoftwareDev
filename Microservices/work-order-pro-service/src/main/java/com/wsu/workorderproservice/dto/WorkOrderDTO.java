package com.wsu.workorderproservice.dto;

import com.wsu.workorderproservice.model.constants.WorkOrderStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderDTO {

    private Integer workOrderNumber;
    @NotBlank(message = "Status code must not be null or blank")
    private WorkOrderStatus statusCode;
    @NotNull(message = "Date ordered must not be null")
    private Date dateOrdered;
    @NotNull(message = "Customer id must not be null")
    @Min(value = 1)
    private Integer customerId;
    private Date dateTimeScheduled;
    private String technicianCode;
    private Date dateTimeCompleted;
    private Date dateTimeLastUpdated;
    private Set<WorkOrderLineItemDTO> lineItems;
}
