package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.CustomerDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.model.Customer;
import com.wsu.workorderproservice.repository.CustomerRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTests {

    @InjectMocks
    private CustomerService customerService;

    @Spy
    private CustomerRepository customerRepository;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    void getCustomers_whenCustomersFound_thenReturnsCustomerPaginatedResponse() throws ParseException {
        when(customerRepository.findBySearch("LastName", PageRequest.of(1, 5, Sort.by("firstName").ascending())))
                .thenReturn(mockCustomerObjectPage());
        Page<CustomerDTO> customerDTOPage = customerService.get("LastName", "firstName", "asc", 2, 5);

        assertTrue(!customerDTOPage.isEmpty());
        assertEquals(1, customerDTOPage.getTotalPages());
        assertEquals(1, customerDTOPage.getTotalElements());
        CustomerDTO customerDTO = customerDTOPage.getContent().get(0);

        assertEquals("test@gmail.com", customerDTO.getEmail());
        assertEquals("9012234560", customerDTO.getPhone());
        assertEquals("45342", customerDTO.getZip());
        assertEquals("OH", customerDTO.getState());
        assertEquals("123 XYZ", customerDTO.getAddressLine1());
        assertEquals("", customerDTO.getAddressLine2());
        assertEquals("Dayton", customerDTO.getCity());
        assertEquals("FirstName", customerDTO.getFirstName());
        assertEquals("LastName", customerDTO.getLastName());
    }

    @Test
    void getCustomers_whenCustomersNotFound_thenReturnsEmptyPage() throws ParseException {
        when(customerRepository.findBySearch("Test", PageRequest.of(1, 5, Sort.by("firstName").ascending())))
                .thenReturn(new PageImpl<>(Collections.emptyList()));
        Page<CustomerDTO> customerDTOPage = customerService.get("Test", "firstName", "asc", 2, 5);

        assertTrue(customerDTOPage.isEmpty());
    }

    @Test
    void getCustomers_whenExceptionOccurs_thenThrowDatabaseErrorException() throws ParseException {
        when(customerRepository.findBySearch("Test", PageRequest.of(0, 5, Sort.by("firstName").descending())))
                .thenThrow(RuntimeException.class);
        assertThrows(DatabaseErrorException.class, ()-> customerService.get("Test", "firstName", "desc", 1, 5));
    }

    @Test
    void addCustomer_whenCustomerEmailDoesNotExists_thenCreateCustomer() {
        when(customerRepository.existsByEmail("test@gmail.com")).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(Customer.builder().id(1)
                .email("test@gmail.com").phone("9012234560").zip("45342").state("OH").addressLine1("123 XYZ")
                .addressLine2("").city("Dayton").firstName("FirstName").lastName("LastName").build());

        CustomerDTO customerDTOResp = customerService.save(mockCustomerDTO());

        assertEquals(1, customerDTOResp.getId());
        assertEquals("test@gmail.com", customerDTOResp.getEmail());
        assertEquals("9012234560", customerDTOResp.getPhone());
        assertEquals("45342", customerDTOResp.getZip());
        assertEquals("OH", customerDTOResp.getState());
        assertEquals("123 XYZ", customerDTOResp.getAddressLine1());
        assertEquals("", customerDTOResp.getAddressLine2());
        assertEquals("Dayton", customerDTOResp.getCity());
        assertEquals("FirstName", customerDTOResp.getFirstName());
        assertEquals("LastName", customerDTOResp.getLastName());
    }

    @Test
    void addCustomer_whenCustomerEmailExists_thenThrowsInvalidRequestException() {
        when(customerRepository.existsByEmail("test@gmail.com")).thenReturn(true);
        assertThrows(InvalidRequestException.class, ()-> customerService.save(mockCustomerDTO()));
    }

    @Test
    void addCustomer_whenExceptionOccurs_thenThrowsDatabaseErrorException() {
        when(customerRepository.existsByEmail("test@gmail.com")).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenThrow(RuntimeException.class);

        assertThrows(DatabaseErrorException.class, ()-> customerService.save(mockCustomerDTO()));
    }

    @Test
    void updateCustomer_whenCustomerExist_thenUpdateCustomer() {
        when(customerRepository.existsById(1)).thenReturn(true);
        when(customerRepository.save(any(Customer.class))).thenReturn(Customer.builder().id(1)
                .email("test@gmail.com").phone("9012234560").zip("45342").state("OH").addressLine1("456 XYZ")
                .addressLine2("").city("Miamisburg").firstName("FirstName").lastName("LastName").build());
        CustomerDTO customerDTO = mockCustomerDTO();
        customerDTO.setCity("Miamisburg");
        customerDTO.setAddressLine1("456 XYZ");

        CustomerDTO customerDTOResp = customerService.update(1, customerDTO);

        assertEquals(1, customerDTOResp.getId());
        assertEquals("test@gmail.com", customerDTOResp.getEmail());
        assertEquals("9012234560", customerDTOResp.getPhone());
        assertEquals("45342", customerDTOResp.getZip());
        assertEquals("OH", customerDTOResp.getState());
        assertEquals("456 XYZ", customerDTOResp.getAddressLine1());
        assertEquals("", customerDTOResp.getAddressLine2());
        assertEquals("Miamisburg", customerDTOResp.getCity());
        assertEquals("FirstName", customerDTOResp.getFirstName());
        assertEquals("LastName", customerDTOResp.getLastName());
    }

    @Test
    void updateCustomer_whenCustomerDoesNotExists_thenThrowsInvalidRequestException() {
        when(customerRepository.existsById(1)).thenReturn(false);
        assertThrows(InvalidRequestException.class, ()-> customerService.update(1, mockCustomerDTO()));
    }

    @Test
    void updateCustomer_whenExceptionOccurs_thenThrowsDatabaseErrorException() {
        when(customerRepository.existsById(1)).thenReturn(true);
        when(customerRepository.save(any(Customer.class))).thenThrow(RuntimeException.class);
        assertThrows(DatabaseErrorException.class, ()-> customerService.update(1, mockCustomerDTO()));
    }

    @Test
    void deleteCustomer_whenCustomerExist_thenDeleteCustomer() {
        when(customerRepository.existsById(1)).thenReturn(true);
        customerService.delete(1);
        verify(customerRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteCustomer_whenCustomerDoesNotExists_thenThrowsInvalidRequestException() {
        when(customerRepository.existsById(1)).thenReturn(false);
        assertThrows(InvalidRequestException.class, ()-> customerService.delete(1));
    }

    @Test
    void deleteCustomer_whenExceptionOccurs_thenThrowsDatabaseErrorException() {
        when(customerRepository.existsById(1)).thenReturn(true);
        doThrow(RuntimeException.class).when(customerRepository).deleteById(1);
        assertThrows(DatabaseErrorException.class, ()-> customerService.delete(1));
    }

    private Page<Object[]> mockCustomerObjectPage() throws ParseException {
        return new PageImpl<>(Collections.singletonList(new Object[]{1, "FirstName", "LastName", "123 XYZ",
                "", "Dayton", "OH", "45342", "9012234560", "test@gmail.com", sdf.parse("2024-10-25 14:00:45"),
                sdf.parse("2024-10-24 11:40:45"), "Completed"}));
    }

    private CustomerDTO mockCustomerDTO() {
        return CustomerDTO.builder().id(1).latestWorkOrderStatus("Unscheduled").email("test@gmail.com")
                .phone("9012234560").zip("45342").state("OH").addressLine1("123 XYZ").addressLine2("")
                .city("Dayton").firstName("FirstName").lastName("LastName").build();
    }

}
