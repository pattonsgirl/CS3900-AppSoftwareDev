package com.wsu.workorderproservice.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.wsu.workorderproservice.dto.TechnicianDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TechnicianService {

    public Page<TechnicianDTO> get(String search, String sortField, 
        String sortOrder, Integer page, Integer rpp) {
        return null;
    }

}
