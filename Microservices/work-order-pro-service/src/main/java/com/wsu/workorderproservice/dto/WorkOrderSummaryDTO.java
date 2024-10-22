package com.wsu.workorderproservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkOrderSummaryDTO {

    private Integer workOrderNumber;
    private String customerLastName;
    private String customerFirstName;
    private String technicianLastName;
    private String technicianFirstName;
    private String technicianCode;
    private Date dateScheduled;
    private Date dateLastUpdated;
    private String workOrderStatus;

}
