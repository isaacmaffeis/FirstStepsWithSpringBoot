package com.isaacmaffeis.firststepswithspringboot.examples.database.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author_A {

    private Long id;

    private String name;

    private Integer age;

}
