package com.endriu.bookstore.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BOOK")
@Builder
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "GENRE")
    private Genre genre;

    @Column(name = "ISBN10")
    private String isbn10;

    @Column(name = "ISBN13")
    private String isbn13;

    @Column(name = "PRICE")
    private BigDecimal price;

}
