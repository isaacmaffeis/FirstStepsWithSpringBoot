package com.isaacmaffeis.firststepswithspringboot.examples.database.dao.impl;

import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.domain.Author_A;
import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Author_A authorA) {
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
                authorA.getId(), authorA.getName(), authorA.getAge()
        );
    }

    @Override
    public Optional<Author_A> findOne(long authorId) {
        List<Author_A> results = jdbcTemplate.query(
                "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
                new AuthorRowMapper(), authorId);

        return results.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author_A> {

        @Override
        public Author_A mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author_A.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }

    @Override
    public List<Author_A> find() {
        return jdbcTemplate.query(
                "SELECT id, name, age FROM authors",
                new AuthorRowMapper()
        );
    }

    @Override
    public void update(long id, Author_A authorA) {
        jdbcTemplate.update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                authorA.getId(), authorA.getName(), authorA.getAge(), id
        );
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(
                "DELETE FROM authors where id = ?",
                id
        );
    }
}