package com.bookweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.bookweb.entity.Book;

@Controller
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:9001/bookstore-api/books";
    
    @GetMapping
    public String bookListPage(Model model){
        ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);
        Book[] books = response.getBody();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/agregar")
    public String addBookPage(Model model){
        return "book-add";
    }
}
