package com.endriu.bookstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ISBN10")
    private String isbn10;

    @Column(name = "ISBN13")
    private String isbn13;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "DATE_OF_PUBLICATION")
    private LocalDate dateOfPublication;

    @Column(name = "PRICE")
    private BigDecimal price;

}
