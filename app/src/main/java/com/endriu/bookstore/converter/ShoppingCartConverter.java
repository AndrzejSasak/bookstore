package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.ShoppingCart;
import com.endriu.bookstore.model.ShoppingCartModel;

public interface ShoppingCartConverter {

    ShoppingCartModel convertToCartModel(ShoppingCart shoppingCart);
    ShoppingCart convertToCart(ShoppingCartModel shoppingCartModel);

}

