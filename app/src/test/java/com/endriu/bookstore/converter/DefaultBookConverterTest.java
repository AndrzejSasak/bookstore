package com.endriu.bookstore.converter;


import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Genre;
import com.endriu.bookstore.model.BookModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultBookConverterTest {

    private DefaultBookConverter defaultBookConverter;

    private static final long ID = 1L;
    private final String TITLE = "Harry Potter 1 and the Philosopher's Stone";
    private static final String AUTHOR = "J. K. Rowling";
    private static final String DESCRIPTION = "Harry Potter book";
    private static final Genre GENRE = Genre.FANTASY;
    private static final String ISBN_10 = "9781408855652";
    private static final String ISBN_13 = "978-1408855652";
    private static final BigDecimal PRICE = BigDecimal.valueOf(38);

    @BeforeEach
    void setUp() {
        defaultBookConverter = new DefaultBookConverter();
    }

    @Test
    void convertToBookModel_givenBook_returnBookModel() {
        //given
        Book book = Book.builder()
                .id(ID)
                .title(TITLE)
                .author(AUTHOR)
                .description(DESCRIPTION)
                .genre(GENRE)
                .isbn10(ISBN_10)
                .isbn13(ISBN_13)
                .price(PRICE)
                .build();

        //when
        BookModel bookModel = defaultBookConverter.convertToBookModel(book);

        //then
        assertEquals(ID, bookModel.getId());
        assertEquals(TITLE, bookModel.getTitle());
        assertEquals(AUTHOR, bookModel.getAuthor());
        assertEquals(DESCRIPTION, bookModel.getDescription());
        assertEquals(GENRE.toString(), bookModel.getGenre());
        assertEquals(ISBN_10, bookModel.getIsbn10());
        assertEquals(ISBN_13, bookModel.getIsbn13());
        assertEquals(PRICE, bookModel.getPrice());
    }

    @Test
    void convertToBook_givenBookModel_returnBook() {
        //given
        BookModel bookModel = new BookModel()
                .id(ID)
                .title(TITLE)
                .author(AUTHOR)
                .description(DESCRIPTION)
                .genre(GENRE.toString())
                .isbn10(ISBN_10)
                .isbn13(ISBN_13)
                .price(PRICE);

        //when
        Book book = defaultBookConverter.convertToBook(bookModel);

        //then
        assertEquals(ID, book.getId());
        assertEquals(TITLE, book.getTitle());
        assertEquals(AUTHOR, book.getAuthor());
        assertEquals(DESCRIPTION, book.getDescription());
        assertEquals(GENRE, book.getGenre());
        assertEquals(ISBN_10, book.getIsbn10());
        assertEquals(ISBN_13, book.getIsbn13());
        assertEquals(PRICE,  book.getPrice());
    }

}
