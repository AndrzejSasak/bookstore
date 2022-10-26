package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.ShoppingCart;
import com.endriu.bookstore.model.CartModel;

public class DefaultCartConverter implements CartConverter {

    private final OrderItemConverter orderItemConverter;

    public DefaultCartConverter(OrderItemConverter orderItemConverter) {
        this.orderItemConverter = orderItemConverter;
    }

    @Override
    public CartModel convertToCartModel(ShoppingCart shoppingCart) {
        CartModel cartModel = new CartModel();
        cartModel.price(shoppingCart.getPrice());
        cartModel.orderItemModels(shoppingCart.getOrderItems().stream()
                .map(orderItemConverter::convertToOrderItemModel)
                .toList());

        return cartModel;
    }

    @Override
    public ShoppingCart convertToCart(CartModel cartModel) {
        return ShoppingCart.builder()
                .price(cartModel.getPrice())
                .orderItems(cartModel.getOrderItemModels().stream()
                        .map(orderItemConverter::convertToOrderItem)
                        .toList())
                .build();
    }
}
