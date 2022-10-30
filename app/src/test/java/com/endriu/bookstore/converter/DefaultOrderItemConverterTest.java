package com.endriu.bookstore.converter;

import com.endriu.bookstore.domain.Book;
import com.endriu.bookstore.domain.Genre;
import com.endriu.bookstore.domain.OrderItem;
import com.endriu.bookstore.model.BookModel;
import com.endriu.bookstore.model.OrderItemModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultOrderItemConverterTest {

    private final long ORDER_ITEM_ID = 1L;
    private final int ORDER_ITEM_AMOUNT = 2;
    private final BigDecimal ORDER_ITEM_PRICE = BigDecimal.valueOf(76);

    private final long BOOK_ID = 1L;
    private final String BOOK_TITLE = "Harry Potter 1 and the Philosopher's Stone";
    private final String BOOK_AUTHOR = "J. K. Rowling";
    private final String BOOK_DESCRIPTION = "Harry Potter book";
    private final Genre BOOK_GENRE = Genre.FANTASY;
    private final String BOOK_ISBN_10 = "9781408855652";
    private final String BOOK_ISBN_13 = "978-1408855652";
    private final BigDecimal BOOK_PRICE = BigDecimal.valueOf(78);

    private DefaultOrderItemConverter defaultOrderItemConverter;
    private DefaultBookConverter defaultBookConverter;

    @BeforeEach
    void setUp() {
        defaultBookConverter = mock(DefaultBookConverter.class);
        defaultOrderItemConverter = new DefaultOrderItemConverter(defaultBookConverter);
    }

    @Test
    void convertToOrderItemModel_givenOrderItem_returnOrderItemModel() {
        //given
        OrderItem orderItem = getOrderItem();
        BookModel bookModel = getBookModel();

        when(defaultBookConverter.convertToBookModel(any())).thenReturn(bookModel);

        //when
        OrderItemModel orderItemModel = defaultOrderItemConverter.convertToOrderItemModel(orderItem);

        //then
        assertEquals(ORDER_ITEM_ID, orderItemModel.getId());
        assertEquals(String.valueOf(ORDER_ITEM_AMOUNT), orderItemModel.getAmount());
        assertEquals(ORDER_ITEM_PRICE, orderItemModel.getPrice());
        assertEquals(bookModel, orderItemModel.getBookModel());
    }

    @Test
    void convertToOrderItem_givenOrderItemModel_returnOrderItem() {
        //given
        OrderItemModel orderItemModel = getOrderItemModel();
        Book book = getBook();

        when(defaultBookConverter.convertToBook(any())).thenReturn(book);

        //when
        OrderItem orderItem = defaultOrderItemConverter.convertToOrderItem(orderItemModel);

        //then
        assertEquals(ORDER_ITEM_ID, orderItem.getId());
        assertEquals(ORDER_ITEM_AMOUNT, orderItem.getAmount());
        assertEquals(ORDER_ITEM_PRICE, orderItem.getPrice());
        assertEquals(book, orderItem.getBook());
    }

    private Book getBook() {
        return Book.builder()
                .id(BOOK_ID)
                .title(BOOK_TITLE)
                .author(BOOK_AUTHOR)
                .build();
    }

    private OrderItemModel getOrderItemModel() {
        return new OrderItemModel()
                .id(ORDER_ITEM_ID)
                .amount(String.valueOf(ORDER_ITEM_AMOUNT))
                .price(ORDER_ITEM_PRICE)
                .bookModel(getBookModel());
    }

    private BookModel getBookModel() {
        return new BookModel()
                .id(BOOK_ID)
                .title(BOOK_TITLE)
                .author(BOOK_AUTHOR)
                .description(BOOK_DESCRIPTION)
                .genre(BOOK_GENRE.toString())
                .isbn10(BOOK_ISBN_10)
                .isbn13(BOOK_ISBN_13)
                .price(BOOK_PRICE);
    }

    private OrderItem getOrderItem() {
        return OrderItem.builder()
                .id(ORDER_ITEM_ID)
                .amount(ORDER_ITEM_AMOUNT)
                .price(ORDER_ITEM_PRICE)
                .book(Book.builder()
                        .id(BOOK_ID)
                        .title(BOOK_TITLE)
                        .author(BOOK_AUTHOR)
                        .description(BOOK_DESCRIPTION)
                        .genre(BOOK_GENRE)
                        .isbn10(BOOK_ISBN_10)
                        .isbn13(BOOK_ISBN_13)
                        .price(BOOK_PRICE)
                        .build())
                .build();
    }

}
