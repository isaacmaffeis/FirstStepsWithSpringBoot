package com.isaacmaffeis.firststepswithspringboot.database.dao.impl;

import com.isaacmaffeis.firststepswithspringboot.database.dao.domain.Author_A;
import com.isaacmaffeis.firststepswithspringboot.database.dao.domain.Book_A;
import com.isaacmaffeis.firststepswithspringboot.database.dao.AuthorDao;
import com.isaacmaffeis.firststepswithspringboot.database.dao.TestDataUtil_A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookADaoImplIntegrationTests {

    private AuthorDao authorDao;
    private BookDaoImpl underTest;

    @Autowired
    public BookADaoImplIntegrationTests(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author_A authorA = TestDataUtil_A.createTestAuthorA();
        authorDao.create(authorA);
        Book_A bookA = TestDataUtil_A.createTestBookA();
        bookA.setAuthorId(authorA.getId());
        underTest.create(bookA);
        Optional<Book_A> result = underTest.findOne(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author_A authorA = TestDataUtil_A.createTestAuthorA();
        authorDao.create(authorA);

        Book_A bookAA = TestDataUtil_A.createTestBookA();
        bookAA.setAuthorId(authorA.getId());
        underTest.create(bookAA);

        Book_A bookAB = TestDataUtil_A.createTestBookB();
        bookAB.setAuthorId(authorA.getId());
        underTest.create(bookAB);

        Book_A bookAC = TestDataUtil_A.createTestBookC();
        bookAC.setAuthorId(authorA.getId());
        underTest.create(bookAC);

        List<Book_A> result = underTest.find();
        assertThat(result)
                .hasSize(3)
                .containsExactly(bookAA, bookAB, bookAC);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author_A authorA = TestDataUtil_A.createTestAuthorA();
        authorDao.create(authorA);

        Book_A bookAA = TestDataUtil_A.createTestBookA();
        bookAA.setAuthorId(authorA.getId());
        underTest.create(bookAA);

        bookAA.setTitle("UPDATED");
        underTest.update(bookAA.getIsbn(), bookAA);

        Optional<Book_A> result = underTest.findOne(bookAA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookAA);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author_A authorA = TestDataUtil_A.createTestAuthorA();
        authorDao.create(authorA);

        Book_A bookAA = TestDataUtil_A.createTestBookA();
        bookAA.setAuthorId(authorA.getId());
        underTest.create(bookAA);

        underTest.delete(bookAA.getIsbn());

        Optional<Book_A> result = underTest.findOne(bookAA.getIsbn());
        assertThat(result).isEmpty();
    }
}