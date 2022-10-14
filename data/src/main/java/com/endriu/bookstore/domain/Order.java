package com.endriu.bookstore.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Long id;
    private BigDecimal price;
    private LocalDateTime timestampCreated;
    private Customer customer;
    private List<OrderItem> orderItems;

}
