package com.isaacmaffeis.firststepswithspringboot.examples.jackson;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaacmaffeis.firststepswithspringboot.examples.jackson.domain.Book_B;
import org.junit.jupiter.api.Test;

public class JacksonTests {

    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Book_B bookB =
                Book_B.builder()
                        .isbn("978-0-13-478627-5")
                        .title("The Enigma of Eternity")
                        .author("Aria Montgomery")
                        .yearPublished("2005")
                        .build();

        String result = objectMapper.writeValueAsString(bookB);
        assertThat(result)
                .isEqualTo(
                        "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria"
                                + " Montgomery\",\"year\":\"2005\"}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject()
            throws JsonProcessingException {
        Book_B bookB =
                Book_B.builder()
                        .isbn("978-0-13-478627-5")
                        .title("The Enigma of Eternity")
                        .author("Aria Montgomery")
                        .yearPublished("2005")
                        .build();
        String json =
                "{\"foo\":\"bar\", \"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of"
                        + " Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}";

        final ObjectMapper objectMapper = new ObjectMapper();

        Book_B result = objectMapper.readValue(json, Book_B.class);
        assertThat(result).isEqualTo(bookB);
    }
}
