package com.endriu.bookstore.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShoppingCart {

    private BigDecimal price;
    private List<OrderItem> orderItems;

    public void updateCart(Book book, int amount) {
        OrderItem orderItem = new OrderItem(book, amount);

        if(orderItem.getAmount() == 0) {
            removeFromOrderItems(orderItem.getBook());
        } else {
            updateOrderItems(orderItem);
        }
    }

    private void updateOrderItems(OrderItem orderItem) {
        if(containsBook(orderItem.getBook())) {
            removeFromOrderItems(orderItem.getBook());
        }

        orderItems.add(orderItem);
        price = price.add(orderItem.getPrice());
    }

    private void removeFromOrderItems(Book book) {
        Optional<OrderItem> itemToRemove = getItemToRemove(book);

        if(itemToRemove.isPresent()) {
            OrderItem item = itemToRemove.get();
            orderItems.remove(item);
            price = price.subtract(item.getPrice());
        }

    }

    private Optional<OrderItem> getItemToRemove(Book book) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getBook().equals(book))
                .findFirst();
    }

    private boolean containsBook(Book book) {
        return orderItems.stream()
                .map(OrderItem::getBook)
                .toList()
                .contains(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(price, that.price) && Objects.equals(orderItems, that.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, orderItems);
    }
}
