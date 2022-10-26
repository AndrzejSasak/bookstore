package com.endriu.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

}
