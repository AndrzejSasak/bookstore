package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.OrderItem;
import com.endriu.bookstore.model.OrderItemModel;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultOrderItemConverter implements OrderItemConverter {

    private final BookConverter bookConverter;

    @Autowired
    public DefaultOrderItemConverter(BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }

    @Override
    public OrderItemModel convertToOrderItemModel(OrderItem orderItem) {
        OrderItemModel orderItemModel = new OrderItemModel();
        orderItemModel.amount(String.valueOf(orderItem.getAmount()));
        orderItemModel.price(orderItem.getPrice());
        orderItemModel.bookModel(bookConverter.convertToBookModel(orderItem.getBook()));

        return orderItemModel;
    }

    @Override
    public OrderItem convertToOrderItem(OrderItemModel orderItemModel) {
        return OrderItem.builder()
                .amount(Integer.parseInt(orderItemModel.getAmount()))
                .price(orderItemModel.getPrice())
                .book(bookConverter.convertToBook(orderItemModel.getBookModel()))
                .build();

    }
}
