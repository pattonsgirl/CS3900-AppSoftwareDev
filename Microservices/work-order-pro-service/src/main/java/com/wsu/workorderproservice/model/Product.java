package com.wsu.workorderproservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "sku_code")
    private String code;
    @Column(name = "sku_description")
    private String name;
    @Column(name = "unit_cost")
    private BigDecimal unitCost;
    @Column(name = "product_type_code")
    private Character typeCode;
    @Column(name = "universal_product_code")
    private String universalProductCode;
    @Column(name = "active")
    private boolean active;

}
