package com.wsu.workorderproservice.controller;

import com.wsu.workorderproservice.dto.CustomerDTO;
import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.service.CustomerService;
import com.wsu.workorderproservice.utilities.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;
import static com.wsu.workorderproservice.utilities.Constants.PAGE_COUNT;
import static com.wsu.workorderproservice.utilities.Constants.RESULT_COUNT;


/**
 * This controller class created for Customer resource CRUD endpoints
 */
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * This method used for retrieve the Customers based on given pagination and filter
     * @param search - allow to filter by customer firstName, lastName, city, state, workOrder status
     * @param page - no. of page (default 1)
     * @param rpp - results per page (default 10)
     * @param sortField - sort field for sorting the results (default dateLastUpdated)
     * @param sortOrder - sort order (default desc)
     * @return - list of customers that's matched given criteria
     */
    @GetMapping
    public ResponseEntity<ServiceResponseDTO> getCustomers(@RequestParam(required = false) String search,
                                                  @RequestParam(required = false, defaultValue = "1") Integer page,
                                                  @RequestParam(required = false, defaultValue = "10") Integer rpp,
                                                  @RequestParam(required = false, defaultValue = "dateLastUpdated") String sortField,
                                                  @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder) {
        Page<CustomerDTO> customerDTOPagePage = customerService.get(search, sortField, sortOrder, page, rpp);
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Customers retrieved successfully.", PAGE_COUNT,
                customerDTOPagePage.getTotalPages(), RESULT_COUNT, customerDTOPagePage.getTotalElements())).data(customerDTOPagePage.getContent())
                .build(), HttpStatus.OK);
    }

}
