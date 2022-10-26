package com.endriu.bookstore.controller;

import com.endriu.bookstore.api.OrderserviceApi;
import com.endriu.bookstore.model.CartModel;
import com.endriu.bookstore.model.OrderModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController implements OrderserviceApi {

    @Override
    public ResponseEntity<List<OrderModel>> orderserviceOrdersGet() {
        return null;
    }

    @Override
    public ResponseEntity<OrderModel> orderserviceOrdersOrderIdGet(Long orderId) {
        return null;
    }

    @Override
    public ResponseEntity<OrderModel> orderserviceOrdersPost(CartModel cartModel) {
        return null;
    }
}
