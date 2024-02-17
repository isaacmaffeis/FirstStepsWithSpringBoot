package com.isaacmaffeis.firststepswithspringboot.jpa.repositories;

import com.isaacmaffeis.firststepswithspringboot.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String>  {
}