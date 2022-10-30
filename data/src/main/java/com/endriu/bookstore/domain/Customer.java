package com.endriu.bookstore.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private BigDecimal balance;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orders;

    @Transient
    private ShoppingCart shoppingCart;

    public boolean hasEmptyShoppingCart() {
        return this.getShoppingCart().getOrderItems().isEmpty();
    }

    public BigDecimal getShoppingCartPrice() {
        return this.shoppingCart.getPrice();
    }

    public List<OrderItem> getOrderItems() {
        return this.shoppingCart.getOrderItems();
    }

    public void updateCart(Book book, int pieces) {
        this.getShoppingCart().updateCart(book, pieces);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public boolean hasLowBalance() {
        return this.balance.subtract(this.shoppingCart.getPrice()).compareTo(BigDecimal.ZERO) < 0;
    }

    public void pay(BigDecimal cost) {
        this.balance = this.balance.subtract(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id)
                && Objects.equals(email, customer.email)
                && Objects.equals(password, customer.password)
                && Objects.equals(name, customer.name)
                && Objects.equals(balance, customer.balance)
                && Objects.equals(orders, customer.orders)
                && Objects.equals(shoppingCart, customer.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, balance, orders, shoppingCart);
    }
}
