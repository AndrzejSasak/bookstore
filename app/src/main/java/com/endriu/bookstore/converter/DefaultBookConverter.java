package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Genre;
import com.endriu.bookstore.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultBookConverter implements BookConverter {


    @Override
    public BookModel convertToBookModel(Book book) {
        return new BookModel()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .genre(book.getGenre().toString())
                .isbn10(book.getIsbn10())
                .isbn13(book.getIsbn13())
                .price(book.getPrice());
    }

    @Override
    public Book convertToBook(BookModel bookModel) {
        return Book.builder()
                .id(bookModel.getId())
                .title(bookModel.getTitle())
                .author(bookModel.getAuthor())
                .description(bookModel.getDescription())
                .genre(Genre.valueOf(bookModel.getGenre()))
                .isbn10(bookModel.getIsbn10())
                .isbn13(bookModel.getIsbn13())
                .price(bookModel.getPrice())
                .build();
    }
}
