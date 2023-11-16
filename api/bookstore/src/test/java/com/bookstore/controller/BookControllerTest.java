package com.bookstore.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.bookstore.entity.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testRegisterBook(){
        Book book = new Book();
        book.setTitle("Crimen y castigo");
        book.setAuthor("Fiodor");
        book.setPublicationYear(1866);
        book.setGenre("Novela policiaca");
        ResponseEntity<Object> response = restTemplate.postForEntity("/libros", book, Object.class);
        assertEquals(200, response.getStatusCode().value());
        
    }
}
