package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Customer;

public interface CustomerService {

    Customer findCustomerByEmail(String email);

}
