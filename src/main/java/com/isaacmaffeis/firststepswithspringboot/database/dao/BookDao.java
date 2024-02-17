package com.isaacmaffeis.firststepswithspringboot.database.dao;

import com.isaacmaffeis.firststepswithspringboot.database.dao.domain.Book_A;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    void create(Book_A bookA);

    Optional<Book_A> findOne(String isbn);

    List<Book_A> find();
    void update(String isbn, Book_A bookA);

    void delete(String isbn);

}
