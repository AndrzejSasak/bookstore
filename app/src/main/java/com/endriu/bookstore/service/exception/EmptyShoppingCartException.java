package com.endriu.bookstore.service.exception;

public class EmptyShoppingCartException extends RuntimeException {

    public EmptyShoppingCartException(String message) {
        super(message);
    }


}
