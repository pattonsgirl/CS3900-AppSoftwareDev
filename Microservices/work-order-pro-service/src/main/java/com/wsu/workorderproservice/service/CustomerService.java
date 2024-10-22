package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.CustomerDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.model.Customer;
import com.wsu.workorderproservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.wsu.workorderproservice.utilities.CommonUtils.sort;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * This method used for retrieve the paginated customers data based on global search
     * @param search - allow to type ahead search by firstName, lastName, city, state, workOrder status
     * @param page - page no.
     * @param rpp - result per page
     * @param sortField - field for sorting the result
     * @param sortOrder - specify order for sorting
     * @return - paginated customers
     */
    public Page<CustomerDTO> get(String search, String sortField, String sortOrder, Integer page, Integer rpp) {
        try {
            Page<Object[]> customers = customerRepository.findBySearch(search, PageRequest.of(page-1, rpp, sort(sortField, sortOrder)));
            return customers.map(customer -> CustomerDTO.builder().id((Integer) customer[0]).firstName((String) customer[1])
                    .lastName((String) customer[2]).addressLine1((String) customer[3]).addressLine2((String) customer[4])
                    .city((String) customer[5]).state((String) customer[6]).zip((String) customer[7]).phone((String) customer[8])
                    .email((String) customer[9]).dateAdded((Date) customer[10]).dateLastUpdated((Date) customer[11])
                    .latestWorkOrderStatus((String) customer[12]).build());
        } catch (Exception e) {
            log.error("Failed to retrieve customers. search:{}, sortField:{}, sortOrder:{}, page:{}, rpp:{}. Exception:",
                    search, sortField, sortOrder, page, rpp, e);
            throw new DatabaseErrorException("Failed to retrieve customers.", e);
        }
    }

    /**
     * This method used for add new customer, if it's not exists
     * @param customerDTO - payload that contains customer info
     * @return - saved customer entity class
     */
    public CustomerDTO save(CustomerDTO customerDTO) {
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            throw new InvalidRequestException("Customer already exist with this email.");
        }
        try {
            return convertToDTO(customerRepository.save(convertToEntity(customerDTO)));
        } catch (Exception e) {
            log.error("Failed to create new customer. Exception:", e);
            throw new DatabaseErrorException("Failed to create new customer", e);
        }
    }

    /**
     * This method used for update customer by customer id
     * @param id - id that's used for update customer
     * @param customerDTO - payload that contains customer info to be updated
     * @return - updated customer dto class
     */
    public CustomerDTO update(Integer id, CustomerDTO customerDTO) {
        if (!customerRepository.existsById(id)) {
            throw new InvalidRequestException("Invalid customer id.");
        }
        try {
            Customer customer = convertToEntity(customerDTO);
            customer.setId(id);
            return convertToDTO(customerRepository.save(customer));
        } catch (Exception e) {
            log.error("Failed to update customer, customerId:{}. Exception:{}", id, e);
            throw new DatabaseErrorException("Failed to update customer", e);
        }
    }

    /**
     * This method used for delete the customer by customer id
     * @param id - id that's used to delete customer
     */
    public void delete(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new InvalidRequestException("Invalid customer id.");
        }
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Failed to delete customer, customerId:{}. Exception:{}", id, e);
            throw new DatabaseErrorException("Failed to delete customer", e);
        }
    }

    /**
     * This method used for convert DTO to entity model class.
     */
    public Customer convertToEntity(CustomerDTO customerDTO) {
        return Customer.builder().firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName()).addressLine1(customerDTO.getAddressLine1())
                .addressLine2(customerDTO.getAddressLine2()).city(customerDTO.getCity())
                .state(customerDTO.getState()).zip(customerDTO.getZip()).phone(customerDTO.getPhone())
                .email(customerDTO.getEmail()).build();
    }

    /**
     * This method used for convert Entity model class to DTO
     */
    public CustomerDTO convertToDTO(Customer customer) {
        return CustomerDTO.builder().id(customer.getId()).firstName(customer.getFirstName())
                .lastName(customer.getLastName()).addressLine1(customer.getAddressLine1())
                .addressLine2(customer.getAddressLine2()).city(customer.getCity())
                .state(customer.getState()).zip(customer.getZip()).phone(customer.getPhone())
                .email(customer.getEmail()).build();
    }
}
