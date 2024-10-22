package com.wsu.workorderproservice.controller;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.dto.WorkOrderSummaryDTO;
import com.wsu.workorderproservice.service.WorkOrderSummaryService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("workOrderSummaries")
public class WorkOrderSummaryController {

    private final WorkOrderSummaryService workOrderSummaryService;

    /**
     * This endpoint used to get list of WorkOrder summary based on given filter and pagination
     * @param customerLastName - It's an optional and used for filter by customer's last name
     * @param technicianLastName - It's an optional and used for filter by technician's last name
     * @param workOrderStatus - It's an optional and used for filter by work order status
     * @param page - it's an optional to specify no. of page (default value is 1)
     * @param rpp - it's an optional to specify results per page (default value is 10)
     * @param sortField - it's an optional and used to specify sort field (default value is dateLastUpdated)
     * @param sortOrder - it's an optional and used to specify sort order (default value is Descending order)
     * @return - returns ServiceResponseDTO which contains list of WorkOrders summary based on filter, page & sorting and pagination details.
     */
    @GetMapping
    public ResponseEntity<ServiceResponseDTO> get(@RequestParam(required = false) String customerLastName,
                                                            @RequestParam(required = false) String technicianLastName,
                                                            @RequestParam(required = false) String workOrderStatus,
                                                            @RequestParam(required = false, defaultValue = "1") Integer page,
                                                            @RequestParam(required = false, defaultValue = "10") Integer rpp,
                                                            @RequestParam(required = false, defaultValue = "dateLastUpdated") String sortField,
                                                            @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder) {
        Page<WorkOrderSummaryDTO> workOrderPage = workOrderSummaryService.get(customerLastName, technicianLastName, workOrderStatus, page, rpp, sortField, sortOrder);
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "WorkOrder Summaries retrieved successfully.", PAGE_COUNT,
                        workOrderPage.getTotalPages(), RESULT_COUNT, workOrderPage.getTotalElements())).data(workOrderPage.getContent())
                .build(), HttpStatus.OK);
    }
}
