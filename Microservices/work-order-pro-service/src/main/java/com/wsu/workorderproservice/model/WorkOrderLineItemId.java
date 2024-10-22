package com.wsu.workorderproservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkOrderLineItemId implements Serializable {

    private Integer workOrderNumber;
    private String skuCode;
}
