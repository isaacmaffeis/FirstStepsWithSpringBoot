package com.isaacmaffeis.firststepswithspringboot.examples.dao.impl;

import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.domain.Author_A;
import com.isaacmaffeis.firststepswithspringboot.examples.dao.TestDataUtil_A;
import com.isaacmaffeis.firststepswithspringboot.examples.database.dao.impl.AuthorDaoImpl;
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
public class AuthorADaoImplIntegrationTests {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorADaoImplIntegrationTests(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author_A authorA = TestDataUtil_A.createTestAuthorA();
        underTest.create(authorA);
        Optional<Author_A> result = underTest.findOne(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author_A authorAA = TestDataUtil_A.createTestAuthorA();
        underTest.create(authorAA);
        Author_A authorAB = TestDataUtil_A.createTestAuthorB();
        underTest.create(authorAB);
        Author_A authorAC = TestDataUtil_A.createTestAuthorC();
        underTest.create(authorAC);

        List<Author_A> result = underTest.find();
        assertThat(result)
                .hasSize(3).
                containsExactly(authorAA, authorAB, authorAC);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author_A authorAA = TestDataUtil_A.createTestAuthorA();
        underTest.create(authorAA);
        authorAA.setName("UPDATED");
        underTest.update(authorAA.getId(), authorAA);
        Optional<Author_A> result = underTest.findOne(authorAA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorAA);
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        Author_A authorAA = TestDataUtil_A.createTestAuthorA();
        underTest.create(authorAA);
        underTest.delete(authorAA.getId());
        Optional<Author_A> result = underTest.findOne(authorAA.getId());
        assertThat(result).isEmpty();
    }
}