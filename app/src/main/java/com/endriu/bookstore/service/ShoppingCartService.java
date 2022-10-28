package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Customer;

public interface ShoppingCartService {

    void updateCart(Customer customer, Book book, int amount);

}
