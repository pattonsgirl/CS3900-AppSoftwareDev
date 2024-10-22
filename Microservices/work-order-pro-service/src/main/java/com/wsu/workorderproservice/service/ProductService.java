package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.dto.ProductDTO;
import com.wsu.workorderproservice.model.Product;
import com.wsu.workorderproservice.repository.ProductRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Retrieves all products and maps to a ProductDTO object.
     * @return - list of ProductDTOs.
     */
    public List<ProductDTO> get(boolean isActive) {
        try {
            if (isActive) {
                return mapToDTO(productRepository.findByActive(true));
            }
            return mapToDTO(productRepository.findAll());
        } catch (Exception e) {
            log.error("Failed to retrieve products. Exception:", e);
            throw new DatabaseErrorException("Failed to retrieve products.", e);
        }

    }

    public List<ProductDTO> mapToDTO(List<Product> products) {
        if (CollectionUtils.isEmpty(products)) {
            return Collections.emptyList();
        }
        return products.stream().map(product -> ProductDTO.builder().code(product.getCode()).name(product.getName())
                .unitCost(product.getUnitCost()).typeCode(product.getTypeCode())
                .universalProductCode(product.getUniversalProductCode()).active(product.isActive()).build()).collect(Collectors.toList());
    }
}
