package com.wsu.workorderproservice.controller;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.service.StateService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    @GetMapping
    public ResponseEntity<ServiceResponseDTO> getStates(@RequestParam(required = false) String search) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "States retrieved successfully."))
                .data(stateService.get(search)).build(), HttpStatus.OK);
    }
}
