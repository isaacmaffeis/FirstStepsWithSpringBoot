package com.isaacmaffeis.firststepswithspringboot.database.dao;

import com.isaacmaffeis.firststepswithspringboot.database.dao.domain.Author_A;
import com.isaacmaffeis.firststepswithspringboot.database.dao.domain.Book_A;

public final class TestDataUtil_A {
    private TestDataUtil_A(){
    }

    public static Author_A createTestAuthorA() {
        return Author_A.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author_A createTestAuthorB() {
        return Author_A.builder()
                .id(2L)
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static Author_A createTestAuthorC() {
        return Author_A.builder()
                .id(3L)
                .name("Jesse A Casey")
                .age(24)
                .build();
    }

    public static Book_A createTestBookA() {
        return Book_A.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book_A createTestBookB() {
        return Book_A.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .authorId(1L)
                .build();
    }

    public static Book_A createTestBookC() {
        return Book_A.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .authorId(1L)
                .build();
    }
}
