package com.endriu.bookstore.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {

    private Long id;
    private Category category;
    private String title;
    private String description;
    private String isbn10;
    private String isbn13;
    private String publisher;
    private LocalDate dateOfPublication;
    private BigDecimal price;

}
