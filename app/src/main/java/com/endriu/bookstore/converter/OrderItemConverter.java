package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.OrderItem;
import com.endriu.bookstore.model.OrderItemModel;

public interface OrderItemConverter {

    OrderItemModel convertToOrderItemModel(OrderItem orderItem);
    OrderItem convertToOrderItem(OrderItemModel orderItemModel);

}
