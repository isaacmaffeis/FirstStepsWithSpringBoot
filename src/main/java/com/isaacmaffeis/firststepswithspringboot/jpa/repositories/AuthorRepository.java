package com.isaacmaffeis.firststepswithspringboot.jpa.repositories;


import com.isaacmaffeis.firststepswithspringboot.jpa.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);

    @Query("SELECT a from Author a where a.age > ?1")
    Iterable<Author> findAuthorsWithAgeGreaterThan(int age);
}