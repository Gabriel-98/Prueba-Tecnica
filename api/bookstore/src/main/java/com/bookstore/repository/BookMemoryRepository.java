package com.bookstore.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bookstore.entity.Book;

@Repository
public class BookMemoryRepository implements BookRepository {
    private List<Book> books;
    private Integer idCounter; // Indica el último id asignado cuando es > 0.

    public BookMemoryRepository(){
        books = new LinkedList<Book>();
        idCounter = 0;
    }

    // Retorna el Book con el id buscado, sino hay tal
    // Book retorna un Optional vacío.
    public Optional<Book> findOne(Integer id){
        ListIterator<Book> iterator = books.listIterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            if(book.getId() == id)
            return Optional.of(book.clone());
        }
        return Optional.empty();
    }

    // Retorna la lista de todos los Books, cada
    // uno de estos es clonado.
    public List<Book> findAll(){
        ListIterator<Book> iterator = books.listIterator();
        LinkedList<Book> books2 = new LinkedList<Book>();
        while(iterator.hasNext()){
            Book book = iterator.next();
            books2.add(book.clone());
        }
        return books2;
    }

    // Inserta un Book al final de la lista.
    // El Book insertado será una copia del original, y
    // además tendrá establecido el siguiente id.
    public Book create(Book book){
        idCounter++;
        Book book2 = book.clone();
        book2.setId(idCounter);
        books.add(book2);
        return book2;
    }

    // Encuentra el Book con el respectivo id, actualiza
    // sus datos y lo retorna, sino hay tal Book retorna
    // un Optional vacío.
    public Optional<Book> update(Book book){
        Integer id = book.getId();
        if(id == null)
        return Optional.empty();
        ListIterator<Book> iterator = books.listIterator();
        while(iterator.hasNext()){
            Book book2 = iterator.next();
            if(book2.getId() == id){
                book2.setTitle(book.getTitle());
                book2.setAuthor(book.getAuthor());
                book2.setPublicationYear(book.getPublicationYear());
                book2.setGenre(book.getGenre());
                return Optional.of(book2.clone());
            }
        }
        return Optional.empty();
    }

    // Remueve el Book con el correspondiente id.
    // Retorna un Optional con el Book eliminado,
    // si ningún elemento fue removido, entonces
    // retorna el Optional vacío.
    public Optional<Book> delete(Integer id){
        ListIterator<Book> iterator = books.listIterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            if(book.getId() == id){
                iterator.remove();
                return Optional.of(book.clone());
            }
        }
        return Optional.empty();
    }
}
