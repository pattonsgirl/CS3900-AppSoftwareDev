package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "Select c.customer_id AS id, c.customer_first_name AS firstName, c.customer_last_name AS lastName, "
            + "c.customer_address_1 AS addressLine1, c.customer_address_2 AS addressLine2, c.customer_city AS city, c.customer_state AS state, "
            + "c.customer_zip AS zip, c.customer_phone AS phone, c.customer_email_address AS email, c.date_added AS dateAdded, "
            + "c.date_last_updated AS dateLastUpdated, wos.work_order_status_desc AS latestWorkOrderStatus "
            + "from customer c left join work_order wo on wo.work_order_number  = (Select max(wo1.work_order_number) from "
            + "work_order wo1 where wo1.customer_id=c.customer_id) left join work_order_status wos on "
            + "wo.work_order_status_code = wos.work_order_status_code where (:search IS NULL OR (c.customer_first_name like %:search% "
            + "OR c.customer_last_name like %:search% OR c.customer_city like %:search% OR c.customer_state like %:search% "
            + "OR wos.work_order_status_desc like %:search%))")
    Page<Object[]> findBySearch(String search, Pageable pageable);

    boolean existsByEmail(String email);

}
