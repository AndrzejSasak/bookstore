package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.ShoppingCart;
import com.endriu.bookstore.model.ShoppingCartModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultCartConverter implements CartConverter {

    private final OrderItemConverter orderItemConverter;

    public DefaultCartConverter(OrderItemConverter orderItemConverter) {
        this.orderItemConverter = orderItemConverter;
    }

    @Override
    public ShoppingCartModel convertToCartModel(ShoppingCart shoppingCart) {
        return new ShoppingCartModel()
                .price(shoppingCart.getPrice())
                .orderItemModels(shoppingCart.getOrderItems().stream()
                        .map(orderItemConverter::convertToOrderItemModel)
                        .toList());
    }

    @Override
    public ShoppingCart convertToCart(ShoppingCartModel shoppingCartModel) {
        return ShoppingCart.builder()
                .price(shoppingCartModel.getPrice())
                .orderItems(shoppingCartModel.getOrderItemModels().stream()
                        .map(orderItemConverter::convertToOrderItem)
                        .toList())
                .build();
    }
}
