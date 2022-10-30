package com.endriu.bookstore.controller;

import com.endriu.bookstore.api.BookserviceApi;
import com.endriu.bookstore.converter.BookConverter;
import com.endriu.bookstore.model.BookModel;
import com.endriu.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController implements BookserviceApi {

    private final BookService bookService;
    private final BookConverter bookConverter;

    public BookController(BookService bookService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
    }

    @Override
    public ResponseEntity<List<BookModel>> bookserviceBooksGet() {
        return new ResponseEntity<>(getBookModelList(), HttpStatus.OK);
    }

    private List<BookModel> getBookModelList() {
        return bookService.getAllBooks().stream()
                .map(bookConverter::convertToBookModel).toList();
    }
}
