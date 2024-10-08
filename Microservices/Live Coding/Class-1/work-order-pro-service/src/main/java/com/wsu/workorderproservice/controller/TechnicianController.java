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

//@RestController is used when you want to return data (e.g. JSON or XML) rather than a view (HTML).
// @ RestController is basically a meta-annotation that combines @Controller and @ResponseBody
@RestController
//@RequiredArgsConstructor is a Lombok annotation that generates constructors for all final and non-null fields.
@RequiredArgsConstructor
//@RequestMapping annotation is used to map requests URI to controllers / methods.
@RequestMapping("technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    /**
     * This endpoint used to retrieve page of technicians based on given filter and pagination.
     * @param search - it's optional and allow to typeahead search by technician firstName, lastName, code, state, WorkOrder status, type
     * @param page - it's optional and used to specify the no. of page (default value is 1).
     * @param rpp - it's optional and used to specify result per page (default value is 10.
     * @param sortField - it's optional and used to specify sort field for sorting the results (default value is technician code)
     * @param sortOrder - it's optional and used to specify sort order for sorting the results (default values is Desc)
     * @return - ServiceResponseDTO which include list of technicians and pagination info along with success message.
     */
    //GetMapping annotation is a shortcut for @RequestMapping(method = RequestMethod.GET) that maps HTTP GET requests to specific handler methods
    //@RequestParam annotation tells Spring that it should map a request parameter from the GET request to your method argument
    // [In RequestParam we can specify parameter is required or not, and also can provide default value if it's not given. If param name is different then we must have to specify that on name field.]
    //ResponseEntity represents the whole HTTP response: status code, headers, and body.
    @GetMapping
    public ResponseEntity<ServiceResponseDTO> get(@RequestParam(required = false) String search, 
        @RequestParam(required = false, defaultValue = "1") Integer page, 
        @RequestParam(required = false, defaultValue = "10") Integer rpp, 
        @RequestParam(required = false, defaultValue = "technicianCode") String sortField, 
        @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder) {
            //In Spring Data, the Page interface represents a sublist of a larger result set, typically used for pagination.
            // It provides methods to access information about the current page, such as the page number, page size, and total number of elements.
            Page<TechnicianDTO> technicianDTOPage = technicianService.get(search, sortField, sortOrder, page, rpp);
            return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(Constants.MESSAGE, 
            "Technicians retrieved successfully", Constants.PAGE_COUNT, technicianDTOPage.getTotalPages(), 
            Constants.RESULT_COUNT, technicianDTOPage.getTotalElements()))
            .data(technicianDTOPage.getContent()).build(), HttpStatus.OK);
    }

}
