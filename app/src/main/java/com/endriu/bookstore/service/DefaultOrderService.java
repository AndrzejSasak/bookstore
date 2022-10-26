package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DefaultOrderService implements OrderService {

    @Override
    public Order createOrder(Customer customer) {

        ShoppingCart shoppingCart = customer.getShoppingCart();



        Order newOrder = Order.builder()
                .orderItems(shoppingCart.getOrderItems())
                .customer(customer)
                .timestampCreated(LocalDateTime.now())
                .price(shoppingCart.getPrice())
                .build();


        return newOrder;
    }

}
