package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.TechnicianDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.model.State;
import com.wsu.workorderproservice.model.Technician;
import com.wsu.workorderproservice.repository.TechnicianRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import static com.wsu.workorderproservice.utilities.CommonUtils.sort;

//@Service annotation is used to mark a class as a service provider that contains business logic
@Service
//@RequiredArgsConstructor is a Lombok annotation that generates constructors for all final and non-null fields.
@RequiredArgsConstructor
//@Slf4j is a logging annotation for Spring Boot applications that creates a static SLF4J logger instance when applied to a class
@Slf4j
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    /**
     * This method used to retrieve a page of technicians.
     * @param search - allows for type ahead search by technician firstname, lastname, workOrderStatus, technicianCode, state, type.
     * @param sortField - field used for sorting result, default value is technician code.
     * @param sortOrder - specifies order for the returned result, Default value is descending.
     * @param page - specifies which page result have to return
     * @param rpp - specifies how many records have to return on page.
     * @return - Returns Page<TechnicianDTO> mapped from the Page<Object[]> returned from the database.
     */
    public Page<TechnicianDTO> get(String search, String sortField, String sortOrder, Integer page, Integer rpp) {
        try {
            Page<Object[]> technicians = technicianRepository.findBySearch(search, PageRequest.of(page-1, rpp, sort(sortField, sortOrder)));
            return technicians.map(technician -> TechnicianDTO.builder().code((String)technician[0])
                    .firstName((String)technician[1]).lastName((String)technician[2])
                    .latestWorkOrderStatus((String)technician[3]).type((String) technician[4]).workPermits(workPermits((String)technician[5])).build());
        } catch (Exception e) { //Throws database error exception if any exception occurs. We are using ControllerExceptionHandler to handle it.
            log.error("Failed to retrieve technicians. search:{}, sortField:{}, sortOrder:{}, page:{}, rpp:{}, Exception:{}",
                    search, sortField, sortOrder, page, rpp, e);
            throw new DatabaseErrorException("Failed to retrieve technicians", e);
        }
    }

    /**
     * This method used to convert workPermits comma separated Strings to collection of State
     * @param workPermits - comma separated Strings
     * @return - collection of State [We are using Set to keep unique State values]
     */
    public Set<State> workPermits(String workPermits) {
        if (!StringUtils.hasLength(workPermits)) {
            return null;
        }
        List<String> workPermitStates = Arrays.asList(workPermits.split(","));
        return workPermitStates.stream().map(state -> State.builder().code(state).build()).collect(Collectors.toSet());
    }

    /**
     * This method used to convert DTO to entity model class.
     */
    private Technician mapToEntity(TechnicianDTO technicianDTO) {
        Technician technician = Technician.builder().firstName(technicianDTO.getFirstName())
                .lastName(technicianDTO.getLastName()).type(technicianDTO.getType()).build();
        if (!CollectionUtils.isEmpty(technicianDTO.getWorkPermits())) {
            technician.setWorkPermits(technicianDTO.getWorkPermits());
        }
        return technician;
    }

    /**
     * This method used to convert Entity model class to DTO class.
     */
    private TechnicianDTO mapToDto(Technician technician) {
        return  technician != null ? TechnicianDTO.builder().code(technician.getCode())
                .firstName(technician.getFirstName())
                .lastName(technician.getLastName()).type(technician.getType())
                .workPermits(technician.getWorkPermits()).build() : null;
    }

}
