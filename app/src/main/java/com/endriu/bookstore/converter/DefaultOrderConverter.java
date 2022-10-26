package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.model.OrderModel;

import java.time.LocalDateTime;

public class DefaultOrderConverter implements OrderConverter {

    private final OrderItemConverter orderItemConverter;

    public DefaultOrderConverter(OrderItemConverter orderItemConverter) {
        this.orderItemConverter = orderItemConverter;
    }

    @Override
    public OrderModel convertToOrderModel(Order order) {
        OrderModel orderModel = new OrderModel();
        orderModel.price(order.getPrice());
        orderModel.timestampCreated(order.getTimestampCreated().toString());
        orderModel.orderItemModels(order.getOrderItems().stream()
                .map(orderItemConverter::convertToOrderItemModel)
                .toList());
        return null;
    }

}
