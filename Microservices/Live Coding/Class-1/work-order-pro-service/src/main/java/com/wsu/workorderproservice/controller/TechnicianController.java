package com.wsu.workorderproservice.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.dto.TechnicianDTO;
import com.wsu.workorderproservice.service.TechnicianService;
import com.wsu.workorderproservice.utilities.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    @GetMapping
    public ResponseEntity<ServiceResponseDTO> get(@RequestParam(required = false) String search, 
        @RequestParam(required = false, defaultValue = "1") Integer page, 
        @RequestParam(required = false, defaultValue = "10") Integer rpp, 
        @RequestParam(required = false, defaultValue = "technicianCode") String sortField, 
        @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder) {
            Page<TechnicianDTO> technicianDTOPage = technicianService.get(search, sortField, sortOrder, page, rpp);
            return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(Constants.MESSAGE, 
            "Technicians retrieved successfully", Constants.PAGE_COUNT, technicianDTOPage.getTotalPages(), 
            Constants.RESULT_COUNT, technicianDTOPage.getTotalElements()))
            .data(technicianDTOPage.getContent()).build(), HttpStatus.OK);
    }

}
