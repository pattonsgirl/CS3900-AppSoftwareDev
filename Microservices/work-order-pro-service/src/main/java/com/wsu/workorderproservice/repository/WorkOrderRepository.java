package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.WorkOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {

    @Query(nativeQuery = true, value = "Select w.work_order_number as workOrderNumber, c.customer_last_name as customerLastName, " +
            "c.customer_first_name as customerFirstName, t.technician_last_name as technicianLastName, t.technician_first_name  as technicianFirstName, " +
            "t.technician_code as technicianCode, w.date_scheduled  as dateScheduled, w.date_last_updated as dateLastUpdated," +
            "wos.work_order_status_desc as workOrderStatus from work_order w INNER JOIN work_order_status wos on wos.work_order_status_code = w.work_order_status_code " +
            "INNER JOIN customer c on c.customer_id = w.customer_id LEFT JOIN technician t on t.technician_code = w.technician_code " +
            "WHERE (:customerLastName IS NULL OR c.customer_last_name = :customerLastName) AND (:technicianLastName IS NULL OR t.technician_last_name = :technicianLastName) " +
            "AND (:workOrderStatus IS NULL OR wos.work_order_status_desc = :workOrderStatus)")
    Page<Object[]> findBySearch(String customerLastName, String technicianLastName, String workOrderStatus, Pageable pageable);
}
