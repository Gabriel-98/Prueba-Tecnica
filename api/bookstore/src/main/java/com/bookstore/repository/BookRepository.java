package com.bookstore.repository;

import java.util.List;
import java.util.Optional;

import com.bookstore.entity.Book;

public interface BookRepository {
    public Optional<Book> findOne(Integer id);
    public List<Book> findAll();
    public Book create(Book book);
    public Optional<Book> update(Book book);
    public Optional<Book> delete(Integer id);
}
