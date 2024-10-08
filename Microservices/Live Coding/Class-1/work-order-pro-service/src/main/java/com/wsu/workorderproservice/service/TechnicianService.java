package com.wsu.workorderproservice.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.wsu.workorderproservice.dto.TechnicianDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Service annotation is used to mark a class as a service provider that contains business logic
@Service
//@RequiredArgsConstructor is a Lombok annotation that generates constructors for all final and non-null fields.
@RequiredArgsConstructor
//@Slf4j is a logging annotation for Spring Boot applications that creates a static SLF4J logger instance when applied to a class
@Slf4j
public class TechnicianService {

/**
 * This method used to retrieve a page of technicians.
 * @param search - allows for type ahead search by technician firstname, lastname, workOrderStatus, technicianCode, state, type.
 * @param sortField - field used for sorting result, default value is technician code.
 * @param sortOrder - specifies order for the returned result, Default value is descending.
 * @param page - specifies which page result have to return
 * @param rpp - specifies how many records have to return on page.
 * @return - Returns Page<TechnicianDTO> mapped from the Page<Object[]> returned from the database.
 */
    public Page<TechnicianDTO> get(String search, String sortField, 
        String sortOrder, Integer page, Integer rpp) {
        return null;
    }

}
