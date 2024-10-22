package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.WorkOrderSummaryDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.wsu.workorderproservice.utilities.CommonUtils.sort;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkOrderSummaryService {

    private final WorkOrderRepository workOrderRepository;

    /**
     * This method used for get page of WorkOrder based on filter, page & sorting
     * @param customerLastName - It's an optional and used for filter by customer's last name
     * @param technicianLastName - It's an optional and used for filter by technician's last name
     * @param workOrderStatus - It's an optional and used for filter by work order status
     * @param page - it's an optional to specify no. of page (default value is 1)
     * @param rpp - it's an optional to specify results per page (default value is 10)
     * @param sortField - it's an optional and used to specify sort field (default value is dateLastUpdated)
     * @param sortOrder - it's an optional and used to specify sort order (default value is Descending order)
     * @return - returns list of WorkOrders summary based on filter, page & sorting.
     */
    public Page<WorkOrderSummaryDTO> get(String customerLastName, String technicianLastName, String workOrderStatus,
                                            Integer page, Integer rpp, String sortField, String sortOrder) {
        try {
            return workOrderRepository.findBySearch(customerLastName, technicianLastName, workOrderStatus, PageRequest.of(page-1, rpp, sort(sortField, sortOrder)))
                    .map(workOrderObj -> WorkOrderSummaryDTO.builder().workOrderNumber((Integer)workOrderObj[0]).customerLastName((String)workOrderObj[1])
                            .customerFirstName((String)workOrderObj[2]).technicianLastName((String)workOrderObj[3]).technicianFirstName((String)workOrderObj[4])
                            .technicianCode((String)workOrderObj[5]).dateScheduled((Date)workOrderObj[6]).dateLastUpdated((Date)workOrderObj[7])
                            .workOrderStatus((String)workOrderObj[8]).build());
        } catch (Exception e) {
            log.error("Failed to retrieve WorkOrder summaries. customerLastName:{}, technicianLastName:{}, workOrderStatus:{}, page:{}, " +
                    "rpp:{}, sortField:{}, sortOrder:{}, Exception:{}", customerLastName, technicianLastName, workOrderStatus, page, rpp,
                    sortField, sortOrder, e);
            throw new DatabaseErrorException("Failed to retrieve WorkOrder Summaries.", e);
        }
    }

}
