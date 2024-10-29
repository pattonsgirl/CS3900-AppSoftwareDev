package com.wsu.workorderproservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsu.workorderproservice.dto.CustomerDTO;
import com.wsu.workorderproservice.service.CustomerService;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.wsu.workorderproservice.utils.MockRequestBuilders.request;
import static com.wsu.workorderproservice.utils.MockRequestBuilders.requestWithParams;
import static com.wsu.workorderproservice.utils.ServiceResponseDTOBodyMatchers.winResponseBody;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerController.class)
@ActiveProfiles("test")
class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private final String BASE_URL = "/customers";

    @MockBean
    private CustomerService customerService;

    @Spy
    private ObjectMapper objectMapper;

    @Test
    void getCustomers_whenNoParamGiven_thenReturns200WithCustomersBasedOnDefaultParams() throws Exception{
        Page<CustomerDTO> customerDTOPage = mockCustomerPage();
        when(customerService.get(null, "dateLastUpdated", "desc", 1, 10))
                .thenReturn(customerDTOPage);
        mockMvc.perform(request(HttpMethod.GET, BASE_URL))
                .andExpect(status().isOk()).andExpect(winResponseBody().toContain(customerDTOPage.getContent(), CustomerDTO.class));
    }

    @Test
    void getCustomers_whenParamsGiven_thenReturns200WithCustomersBasedOnGivenParams() throws Exception{
        Page<CustomerDTO> customerDTOPage = mockCustomerPage();
        when(customerService.get("FirstName", "lastName", "asc", 2, 5))
                .thenReturn(customerDTOPage);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("page", "2");
        params.add("rpp", "5");
        params.add("sortField", "lastName");
        params.add("sortOrder", "asc");
        params.add("search", "FirstName");
        mockMvc.perform(requestWithParams(HttpMethod.GET, BASE_URL, params))
                .andExpect(status().isOk()).andExpect(winResponseBody().toContain(customerDTOPage.getContent(), CustomerDTO.class));
    }

    @Test
    void getOrAddCustomers_whenValidUrlButInvalidMethodGiven_thenReturns405() throws Exception{
        mockMvc.perform(request(HttpMethod.PATCH, BASE_URL))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(request(HttpMethod.PUT, BASE_URL))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(request(HttpMethod.DELETE, BASE_URL))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void getCustomers_whenInvalidUrlButValidMethodGiven_thenReturns404() throws Exception{
        mockMvc.perform(request(HttpMethod.GET, BASE_URL + "s"))
                .andExpect(status().isNotFound());
    }

    @Test
    void addCustomer_whenValidPayloadGiven_thenReturns201WithAddedCustomer() throws Exception {
        CustomerDTO customerDTO = mockCustomerDTO();
        CustomerDTO customerDTOResp = mockCustomerDTO();
        customerDTOResp.setId(1);
        when(customerService.save(customerDTO)).thenReturn(customerDTOResp);
        mockMvc.perform(request(HttpMethod.POST, BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isCreated())
                .andExpect(winResponseBody().toContain(customerDTOResp, CustomerDTO.class));
    }

    //testing Bean Validation
    @Test
    void addCustomer_whenStateGivenMoreThan2Chars_thenReturns400() throws Exception {
        CustomerDTO customerDTO = mockCustomerDTO();
        customerDTO.setState("OHIO");
        mockMvc.perform(request(HttpMethod.POST, BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addCustomer_whenInvalidUrlButValidMethodGiven_thenReturns404() throws Exception {
        CustomerDTO customerDTO = mockCustomerDTO();
        mockMvc.perform(request(HttpMethod.POST, BASE_URL + "s")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateCustomer_whenValidPayloadGiven_thenReturns200WithUpdatedCustomer() throws Exception {
        CustomerDTO customerDTO = mockCustomerDTO();
        CustomerDTO customerDTOResp = mockCustomerDTO();
        customerDTOResp.setId(1);
        when(customerService.update(1, customerDTO)).thenReturn(customerDTOResp);
        mockMvc.perform(request(HttpMethod.PUT, BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(winResponseBody().toContain(customerDTOResp, CustomerDTO.class));
    }

    //testing Bean Validation
    @Test
    void updateCustomer_whenStateGivenMoreThan2Chars_thenReturns400() throws Exception {
        CustomerDTO customerDTO = mockCustomerDTO();
        customerDTO.setState("OHIO");
        mockMvc.perform(request(HttpMethod.PUT, BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateCustomer_whenInvalidUrlButValidMethodGiven_thenReturns404() throws Exception {
        CustomerDTO customerDTO = mockCustomerDTO();
        mockMvc.perform(request(HttpMethod.PUT, BASE_URL + "/test/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateOrDeleteCustomer_whenValidUrlButInvalidMethodGiven_thenReturns405() throws Exception {
        mockMvc.perform(request(HttpMethod.POST, BASE_URL + "/1"))
                .andExpect(status().isMethodNotAllowed());
        mockMvc.perform(request(HttpMethod.GET, BASE_URL + "/1"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void deleteCustomer_whenValidUrlAndMethodGiven_thenReturns200() throws Exception {
        mockMvc.perform(request(HttpMethod.DELETE, BASE_URL + "/1"))
                .andExpect(status().isOk());
        verify(customerService, times(1)).delete(1);
    }

    @Test
    void deleteCustomer_whenInvalidUrlButValidMethodGiven_thenReturns404() throws Exception {
        mockMvc.perform(request(HttpMethod.DELETE, BASE_URL + "test/1"))
                .andExpect(status().isNotFound());
    }

    private Page<CustomerDTO> mockCustomerPage() {
        CustomerDTO customerDTO = mockCustomerDTO();
        customerDTO.setId(1);
        return new PageImpl<>(Collections.singletonList(customerDTO));
    }

    private CustomerDTO mockCustomerDTO() {
        return CustomerDTO.builder().latestWorkOrderStatus("Unscheduled").email("test@gmail.com")
                .phone("9012234560").zip("45342").state("OH").addressLine1("123 XYZ").addressLine2("")
                .city("Dayton").firstName("FirstName").lastName("LastName").build();
    }
}
