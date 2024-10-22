package com.wsu.workorderproservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "customer_address_1")
    private String addressLine1;

    @Column(name = "customer_address_2")
    private String addressLine2;

    @Column(name = "customer_city")
    private String city;

    @Column(name = "customer_state")
    private String state;

    @Column(name = "customer_zip")
    private String zip;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_email_address")
    private String email;

}
