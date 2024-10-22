package com.wsu.workorderproservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "work_order_detail")
@IdClass(WorkOrderLineItemId.class)
public class WorkOrderLineItem {

    @Id
    @Column(name = "work_order_number")
    private Integer workOrderNumber;
    @Id
    @Column(name = "sku_code")
    private String skuCode;
    private Integer quantity;
    @Column(name = "unit_cost")
    private BigDecimal unitCost; 
    private Boolean taxable;
    private BigDecimal tax;
}
