package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeRent;
     @ManyToOne
    @JoinColumn(name="id_book")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeRent() {
        return codeRent;
    }

    public void setCodeRent(String codeRent) {
        this.codeRent = codeRent;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
