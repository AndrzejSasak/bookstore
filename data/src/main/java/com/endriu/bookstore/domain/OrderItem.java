package com.endriu.bookstore.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEM")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Order order;

    private int amount;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    public OrderItem(Book book, int amount) {
        this.book = book;
        this.amount = amount;
        this.price = book.getPrice().multiply(BigDecimal.valueOf(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return amount == orderItem.amount
                && Objects.equals(id, orderItem.id)
                && Objects.equals(order, orderItem.order)
                && Objects.equals(price, orderItem.price)
                && Objects.equals(book, orderItem.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, amount, price, book);
    }
}
