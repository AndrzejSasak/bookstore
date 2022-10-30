package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.domain.OrderItem;
import com.endriu.bookstore.repository.CustomerRepository;
import com.endriu.bookstore.repository.OrderRepository;
import com.endriu.bookstore.service.exception.EmptyShoppingCartException;
import com.endriu.bookstore.service.exception.NotEnoughFundsException;
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
        checkIfOrderIsPossible(customer);
        List<OrderItem> orderItems = customer.getOrderItems();
        Order newOrder = buildNewOrder(customer, orderItems);
        orderItems.forEach(orderItem -> orderItem.setOrder(newOrder));
        updateCustomerData(customer, newOrder);

        customerRepository.save(customer);
        return orderRepository.save(newOrder);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + id + " doesn't exist"));
    }

    @Override
    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }

    private void checkIfOrderIsPossible(Customer customer) {
        if(customer.hasLowBalance()) {
            throw new NotEnoughFundsException("Not enough funds.");
        }

        if(customer.hasEmptyShoppingCart()) {
            throw new EmptyShoppingCartException("Cannot create order - shopping cart is empty");
        }
    }

    private Order buildNewOrder(Customer customer, List<OrderItem> orderItems) {
        return Order.builder()
                .price(customer.getShoppingCartPrice())
                .timestampCreated(LocalDateTime.now())
                .customer(customer)
                .orderItems(orderItems)
                .build();
    }

    private void updateCustomerData(Customer customer, Order newOrder) {
        customer.addOrder(newOrder);
        customer.pay(newOrder.getPrice());
    }

}
