package com.endriu.bookstore.service;


import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.repository.CustomerRepository;
import com.endriu.bookstore.service.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("No customer with such email found"));
    }

}
