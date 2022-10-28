package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.domain.OrderItem;
import com.endriu.bookstore.domain.ShoppingCart;
import com.endriu.bookstore.repository.CustomerRepository;
import com.endriu.bookstore.repository.OrderItemRepository;
import com.endriu.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultOrderService implements OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public DefaultOrderService(CustomerRepository customerRepository,
                               OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Order createOrder(Customer customer) {

        if(!customer.hasEnoughBalance()) {
            throw new NotEnoughFundsException("Not enough funds.");
        }

        if(!customer.hasOrderItemsInCart()) {
            throw new IllegalStateException("Cart cannot be empty");
        }

        List<OrderItem> orderItems = customer.getOrderItems();

        Order newOrder = Order.builder()
                .customer(customer)
                .price(customer.getCartPrice())
                .timestampCreated(LocalDateTime.now())
                .orderItems(orderItems)
                .build();

        orderItems.forEach(orderItem -> orderItem.setOrder(newOrder));
        customer.addOrder(newOrder);
        customer.pay(newOrder.getPrice());

        customerRepository.save(customer);
        return orderRepository.save(newOrder);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No order with id: " + id + " found"));
    }

}
