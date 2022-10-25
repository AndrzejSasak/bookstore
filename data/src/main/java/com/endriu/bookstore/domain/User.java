package com.endriu.bookstore.domain;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Builder
@MappedSuperclass
public class User {

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

}
