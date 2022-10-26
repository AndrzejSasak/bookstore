package com.endriu.bookstore.service;

import com.endriu.bookstore.converter.BookConverter;
import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    @Autowired
    public DefaultBookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
