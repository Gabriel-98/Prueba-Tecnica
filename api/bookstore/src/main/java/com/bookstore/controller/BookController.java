package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.exceptions.InvalidValueException;
import com.bookstore.exceptions.MandatoryFieldException;
import com.bookstore.exceptions.ObjectNotFoundException;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookInfo(@PathVariable("id") Integer id){
        try{
            Book book = bookService.getBookInfo(id);
            return ResponseEntity.ok(book);
        }
        catch(ObjectNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public String registerBook(@RequestBody Book book){
        try{
            Book book2 = bookService.registerBook(book);
            return "redirect:http://localhost:9002";
//            return ResponseEntity.ok(book2);
        }
       /*catch(MandatoryFieldException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(InvalidValueException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }*/
        catch(Exception e) {
            return "redirect:http://localhost:9002";
            //return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> registerBook2(Book book){
        try{
            Book book2 = bookService.registerBook(book);
            return ResponseEntity.ok(book2);
        }
        catch(MandatoryFieldException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(InvalidValueException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Object> editBookInfo(@RequestBody Book book){
        try{
            Book book2 = bookService.editBookInfo(book);
            return ResponseEntity.ok(book2);
        }
        catch(ObjectNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(MandatoryFieldException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(InvalidValueException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeBook(@PathVariable("id") Integer id){
        try{
            Book book = bookService.removeBook(id);
            return ResponseEntity.ok(book);
        }
        catch(ObjectNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> listAllBooks(){
        try{
            List<Book> books = bookService.listAllBooks();
            return ResponseEntity.ok(books);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
