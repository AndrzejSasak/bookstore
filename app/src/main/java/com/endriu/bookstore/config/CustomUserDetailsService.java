package com.endriu.bookstore.config;

import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.repository.CustomerRepository;
import com.endriu.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerService customerService;

    @Autowired
    public CustomUserDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.findCustomerByEmail(username));

        if(customerOptional.isEmpty()) {
            throw new UsernameNotFoundException("Customer with this username not found");
        }

        Customer customer = customerOptional.get();
        return new User(customer.getEmail(),
                customer.getPassword(),
                true,
                true,
                true,
                true,
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

}
