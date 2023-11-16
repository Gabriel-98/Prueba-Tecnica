package com.bookweb.entity;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;

    public Book(){
        id = 0;
        title = "";
        author = "";
        publicationYear = 0;
        genre = "";
    }

    public Book(Integer id, String title, String author, Integer publicationYear, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public Integer getId(){ return id; }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public Integer getPublicationYear(){ return publicationYear; }
    public String getGenre(){ return genre; }
}