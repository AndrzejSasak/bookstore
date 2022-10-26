package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Order;
import com.endriu.bookstore.model.OrderModel;
import org.springframework.stereotype.Component;


@Component
public class DefaultOrderConverter implements OrderConverter {

    private final OrderItemConverter orderItemConverter;

    public DefaultOrderConverter(OrderItemConverter orderItemConverter) {
        this.orderItemConverter = orderItemConverter;
    }

    @Override
    public OrderModel convertToOrderModel(Order order) {
        return new OrderModel()
                .id(order.getId())
                .price(order.getPrice())
                .timestampCreated(order.getTimestampCreated().toString())
                .orderItemModels(order.getOrderItems().stream()
                        .map(orderItemConverter::convertToOrderItemModel)
                        .toList());
    }

}
