package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Customer;

public class DefaultShoppingCartService implements ShoppingCartService {


    @Override
    public void updateCart(Customer customer, Book book, int amount) {
        customer.updateCart(book, amount);
    }


}
