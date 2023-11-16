package com.bookstore.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.bookstore.exceptions.InvalidValueException;
import com.bookstore.exceptions.MandatoryFieldException;

// Problemas con lombok en VSCode
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;

    public Integer getId(){ return id; }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public Integer getPublicationYear(){ return publicationYear; }
    public String getGenre(){ return genre; }

    public void setId(Integer id){ this.id = id; }
    public void setTitle(String title){ this.title = title; }
    public void setAuthor(String author){ this.author = author; }
    public void setPublicationYear(Integer publicationYear){ this.publicationYear = publicationYear; }
    public void setGenre(String genre){ this.genre = genre; }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Book)) return false;
        Book other = (Book)o;
        if(id != other.getId()) return false;
        if(title == null && other.getTitle() != null) return false;
        if(!title.equals(other.getTitle())) return false;
        if(author == null && other.getAuthor() != null) return false;
        if(!author.equals(other.getAuthor())) return false;
        if(publicationYear != other.getPublicationYear()) return false;
        if(genre == null && other.getGenre() != null) return false;
        if(!genre.equals(other.getGenre())) return false;
        return true;
    }

    public void validateMandatoryFields(boolean isIdMandatory) throws MandatoryFieldException {
        if(isIdMandatory && id == null)
        throw new MandatoryFieldException("id");
        if(title == null || title.isEmpty())
        throw new MandatoryFieldException("title");
        if(author == null || author.isEmpty())
        throw new MandatoryFieldException("author");
        if(publicationYear == null)
        throw new MandatoryFieldException("publicationYear");
        if(genre == null || genre.isEmpty())
        throw new MandatoryFieldException("genre");
    }

    // Este método es llamado para validar las restricciones sobre los campos,
    // y se asume que los campos a validar no son nulos.
    public void validateConstraints() throws InvalidValueException {
        LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.UTC);
        if(!(1 <= title.length() && title.length() <= 100))
        throw new InvalidValueException("El campo title debe tener longitud de 1 a 100 caracteres");
        if(!(1 <= author.length() && author.length() <= 100))
        throw new InvalidValueException("El campo author debe tener longitud de 1 a 100 caracteres");
        if(!(publicationYear >= 0 && publicationYear <= dateTime.getYear()))
        throw new InvalidValueException("El campo publicationYear debe ser >= 0 y <= al año actual en UTC");
        if(!(1 <= genre.length() && genre.length() <= 100))
        throw new InvalidValueException("El campo genre debe tener longitud de 1 a 100 caracteres");
    }

    public Book clone(){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(publicationYear);
        book.setGenre(genre);
        return book;
    }
}
