package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.OrderItem;
import com.endriu.bookstore.model.OrderItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultOrderItemConverter implements OrderItemConverter {

    private final BookConverter bookConverter;

    @Autowired
    public DefaultOrderItemConverter(BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }

    @Override
    public OrderItemModel convertToOrderItemModel(OrderItem orderItem) {
        return new OrderItemModel()
                .id(orderItem.getId())
                .amount(String.valueOf(orderItem.getAmount()))
                .price(orderItem.getPrice())
                .bookModel(bookConverter.convertToBookModel(orderItem.getBook()));
    }

    @Override
    public OrderItem convertToOrderItem(OrderItemModel orderItemModel) {
        return OrderItem.builder()
                .id(orderItemModel.getId())
                .amount(Integer.parseInt(orderItemModel.getAmount()))
                .price(orderItemModel.getPrice())
                .book(bookConverter.convertToBook(orderItemModel.getBookModel()))
                .build();

    }
}
