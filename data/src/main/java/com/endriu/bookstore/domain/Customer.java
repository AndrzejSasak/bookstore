package com.endriu.bookstore.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orders;

    @Transient
    private ShoppingCart shoppingCart;

}
