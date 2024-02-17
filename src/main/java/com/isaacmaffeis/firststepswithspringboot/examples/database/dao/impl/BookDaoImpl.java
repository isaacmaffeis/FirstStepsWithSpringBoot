package com.isaacmaffeis.firststepswithspringboot.examples.database.dao.impl;

import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.domain.Book_A;
import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book_A bookA) {
        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
                bookA.getIsbn(),
                bookA.getTitle(),
                bookA.getAuthorId()
        );
    }

    @Override
    public Optional<Book_A> findOne(String isbn) {
        List<Book_A> results = jdbcTemplate.query(
                "SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1",
                new BookRowMapper(),
                isbn
        );
        return results.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book_A> {

        @Override
        public Book_A mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book_A.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .build();
        }

    }

    @Override
    public List<Book_A> find() {
        return jdbcTemplate.query(
                "SELECT isbn, title, author_id from books",
                new BookRowMapper()
        );
    }

    @Override
    public void update(String isbn, Book_A bookA) {
        jdbcTemplate.update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                bookA.getIsbn(), bookA.getTitle(), bookA.getAuthorId(), isbn
        );
    }

    @Override
    public void delete(String isbn) {
        jdbcTemplate.update(
                "DELETE FROM books where isbn = ?",
                isbn
        );
    }
}