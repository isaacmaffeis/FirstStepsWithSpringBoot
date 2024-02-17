package com.isaacmaffeis.firststepswithspringboot.examples.database.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book_A {

    private String isbn;

    private String title;

    private Long authorId;

}
