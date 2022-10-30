package com.endriu.bookstore.domain.statistics;

import com.endriu.bookstore.domain.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerStatistics {

    private Customer customerMostMoneySpent;
    private Customer customerMostBooksBought;
    private Customer customerMostOrders;

}
