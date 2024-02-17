package com.isaacmaffeis.firststepswithspringboot.examples.database.dao;

import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.domain.Author_A;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    void create(Author_A authorA);

    Optional<Author_A> findOne(long l);

    List<Author_A> find();

    void update(long id, Author_A authorA);

    void delete(long id);

}
