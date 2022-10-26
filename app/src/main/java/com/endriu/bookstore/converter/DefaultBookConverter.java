package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Genre;
import com.endriu.bookstore.model.BookModel;

public class DefaultBookConverter implements BookConverter {


    @Override
    public BookModel convertToBookModel(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.title(book.getTitle());
        bookModel.author(book.getAuthor());
        bookModel.description(bookModel.getDescription());
        bookModel.genre(book.getGenre().toString());
        bookModel.isbn10(book.getIsbn10());
        bookModel.isbn13(book.getIsbn13());
        bookModel.price(book.getPrice());

        return bookModel;
    }

    @Override
    public Book convertToBook(BookModel bookModel) {
        return Book.builder()
                .title(bookModel.getTitle())
                .author(bookModel.getAuthor())
                .description(bookModel.getDescription())
                .genre(Genre.valueOf(bookModel.getGenre()))
                .isbn10(bookModel.getIsbn10())
                .isbn10(bookModel.getIsbn13())
                .price(bookModel.getPrice())
                .build();
    }
}
