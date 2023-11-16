package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.exceptions.ObjectNotFoundException;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookInfo(Integer id) throws Exception {
        Optional<Book> bookOpt = bookRepository.findOne(id);
        if(!bookOpt.isPresent())
        throw new ObjectNotFoundException("No existe un libro con ese id");
        return bookOpt.get();
    }

    public Book registerBook(Book book) throws Exception {
        book.validateMandatoryFields(false);
        book.validateConstraints();
        return bookRepository.create(book);
    }

    public Book editBookInfo(Book book) throws Exception {
        book.validateMandatoryFields(true);
        book.validateConstraints();
        Optional<Book> bookOpt = bookRepository.update(book);
        if(!bookOpt.isPresent())
        throw new ObjectNotFoundException("No existe un libro con ese id");
        return bookOpt.get();
    }

    public Book removeBook(Integer id) throws Exception {
        Optional<Book> bookOpt = bookRepository.delete(id);
        if(!bookOpt.isPresent())
        throw new ObjectNotFoundException("No existe un libro con ese id");
        return bookOpt.get();
    }

    public List<Book> listAllBooks() throws Exception {
        return bookRepository.findAll();
    }
}
