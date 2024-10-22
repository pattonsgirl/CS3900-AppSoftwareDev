package com.wsu.workorderproservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderLineItemDTO {

    private Integer workOrderNumber;
    private String skuCode;
    private Integer quantity;
    private BigDecimal unitCost;
    private Boolean taxable;
    private BigDecimal tax;
}
