package com.wsu.workorderproservice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String code;
    private String name;
    private BigDecimal unitCost;
    private Character typeCode;
    private String universalProductCode;
    private boolean active;
}
