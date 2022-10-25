package com.endriu.bookstore.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
public class ShoppingCart {

    private BigDecimal price;
    private List<OrderItem> orderItems;

}
