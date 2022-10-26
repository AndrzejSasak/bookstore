package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.model.OrderModel;

public interface OrderConverter {

    OrderModel convertToOrderModel(Order order);

}
