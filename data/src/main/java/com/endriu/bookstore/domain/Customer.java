package com.endriu.bookstore.domain;

import java.math.BigDecimal;
import java.util.List;

public class Customer {

    private Long id;
    private String name;
    private BigDecimal balance;
    private List<Order> orders;
    private Cart cart;

}
