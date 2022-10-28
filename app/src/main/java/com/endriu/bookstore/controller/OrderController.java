package com.endriu.bookstore.controller;

import com.endriu.bookstore.api.OrderserviceApi;
import com.endriu.bookstore.converter.CartConverter;
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

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class OrderController implements OrderserviceApi {

    private final CustomerService customerService;
    private final OrderConverter orderConverter;
    private final OrderService orderService;
    private final CartConverter cartConverter;

    @Autowired
    public OrderController(CustomerService customerService,
                           OrderConverter orderConverter,
                           OrderService orderService,
                           CartConverter cartConverter) {
        this.customerService = customerService;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.cartConverter = cartConverter;
    }

    @Override
    public ResponseEntity<List<OrderModel>> orderserviceOrdersGet() {
        return new ResponseEntity<>(getCurrentCustomerOrderModelList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderModel> orderserviceOrdersOrderIdGet(@PathVariable Long orderId) {

        Order existingOrder;
        try {
            existingOrder = orderService.getOrderById(orderId);
        } catch(EntityNotFoundException entityNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(!getCurrentCustomer().getId().equals(existingOrder.getCustomer().getId())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        OrderModel orderModel = orderConverter.convertToOrderModel(findOrderOfAuthenticatedCustomer(orderId));
        return new ResponseEntity<>(orderModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderModel> orderserviceOrdersPost(@RequestBody ShoppingCartModel shoppingCartModel) {

        System.out.println(shoppingCartModel);

        Customer customer = getCurrentCustomer();
        customer.setShoppingCart(cartConverter.convertToCart(shoppingCartModel));

        System.out.println(customer.getShoppingCart());

        if(!customer.hasOrderItemsInCart() || !customer.hasEnoughBalance()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        OrderModel orderModel = orderConverter.convertToOrderModel(orderService.createOrder(customer));

        return new ResponseEntity<>(orderModel, HttpStatus.OK);
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
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        return customerService.findCustomerByEmail(user.getUsername());
    }
}
