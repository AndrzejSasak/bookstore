package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.ShoppingCart;
import com.endriu.bookstore.model.CartModel;

public interface CartConverter {

    CartModel convertToCartModel(ShoppingCart shoppingCart);
    ShoppingCart convertToCart(CartModel cartModel);

}

