package com.endriu.bookstore.domain;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;
    private Order order;
    private int amount;
    private BigDecimal price;
    private Book book;

}
