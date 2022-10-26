package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.model.BookModel;

public interface BookConverter {

    BookModel convertToBookModel(Book book);
    Book convertToBook(BookModel bookModel);

}
