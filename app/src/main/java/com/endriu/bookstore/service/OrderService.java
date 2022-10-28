package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.domain.Order;

public interface OrderService {

    Order createOrder(Customer customer);
    Order getOrderById(Long id);

}
