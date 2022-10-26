package com.endriu.bookstore.repository;

import com.endriu.bookstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
