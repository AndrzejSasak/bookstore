package com.endriu.bookstore.domain.statistics;

import com.endriu.bookstore.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStatistics {

    private Book bestSellingBook;
    private Book worstSellingBook;

}
