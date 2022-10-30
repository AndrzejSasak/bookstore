package com.endriu.bookstore.controller;

import com.endriu.bookstore.api.OrderserviceApi;
import com.endriu.bookstore.converter.ShoppingCartConverter;
import com.endriu.bookstore.converter.OrderConverter;
import com.endriu.bookstore.domain.Customer;
import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.model.ShoppingCartModel;
import com.endriu.bookstore.model.OrderModel;
import com.endriu.bookstore.service.CustomerService;
import com.endriu.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OrderController implements OrderserviceApi {

    private final CustomerService customerService;
    private final OrderConverter orderConverter;
    private final OrderService orderService;
    private final ShoppingCartConverter shoppingCartConverter;

    public OrderController(CustomerService customerService,
                           OrderConverter orderConverter,
                           OrderService orderService,
                           ShoppingCartConverter shoppingCartConverter) {
        this.customerService = customerService;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.shoppingCartConverter = shoppingCartConverter;
    }

    @Override
    public ResponseEntity<List<OrderModel>> orderserviceOrdersGet() {
        return new ResponseEntity<>(getCurrentCustomerOrderModelList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderModel> orderserviceOrdersOrderIdGet(@PathVariable Long orderId) {

        if(!orderService.existsById(orderId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(orderBelongsToDifferentCustomer(orderService.getOrderById(orderId))) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(getOrderModelFromId(orderId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderModel> orderserviceOrdersPost(@RequestBody ShoppingCartModel shoppingCartModel) {

        Customer customer = getCurrentCustomer();
        customer.setShoppingCart(shoppingCartConverter.convertToCart(shoppingCartModel));

        if(customer.hasEmptyShoppingCart() || customer.hasLowBalance()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createOrderModel(customer), HttpStatus.OK);
    }

    private OrderModel createOrderModel(Customer customer) {
        return orderConverter.convertToOrderModel(orderService.createOrder(customer));
    }

    private OrderModel getOrderModelFromId(Long orderId) {
        return orderConverter.convertToOrderModel(findOrderOfAuthenticatedCustomer(orderId));
    }

    private boolean orderBelongsToDifferentCustomer(Order order) {
        return !getCurrentCustomer().getId().equals(order.getCustomer().getId());
    }

    private Order findOrderOfAuthenticatedCustomer(Long orderId) {
        return getCurrentCustomer().getOrders().stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    private List<OrderModel> getCurrentCustomerOrderModelList() {
        return getCurrentCustomer().getOrders().stream()
                .map(orderConverter::convertToOrderModel)
                .toList();
    }

    private Customer getCurrentCustomer() {
        User currentCustomer = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        return customerService.findCustomerByEmail(currentCustomer.getUsername());
    }
}
