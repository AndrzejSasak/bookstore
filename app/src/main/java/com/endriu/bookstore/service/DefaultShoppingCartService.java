package com.endriu.bookstore.service;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class DefaultShoppingCartService implements ShoppingCartService {

    @Override
    public void updateCart(Customer customer, Book book, int amount) {
        customer.updateCart(book, amount);
    }

}
