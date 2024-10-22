package com.wsu.workorderproservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wsu.workorderproservice.model.constants.WorkOrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "work_order")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_order_number")
    private Integer workOrderNumber; 
    @Column(name = "work_order_status_code")
    @Enumerated(EnumType.STRING)
    private WorkOrderStatus statusCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_ordered")
    private Date dateOrdered;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "date_scheduled")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeScheduled;
    @Column(name = "technician_code")
    private String technicianCode;
    @Column(name = "date_closed")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeCompleted;
    @Column(name = "date_last_updated")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeLastUpdated;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "work_order_number", updatable = false)
    private Set<WorkOrderLineItem> lineItems;
}
