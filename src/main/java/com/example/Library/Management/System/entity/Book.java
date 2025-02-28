package com.example.Library.Management.System.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id" ,length = 11)
    private int bookID;

    @Column(name = "title" ,length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "autherId")
    private Auther auther;

    @ManyToOne
    @JoinColumn(name = "publisherId")
    private Publisher publisher;



    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;



    public Book(String title) {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book(int bookID, String title, Auther auther, Publisher publisher) {
        this.bookID = bookID;
        this.title = title;
        this.auther = auther;
        this.publisher = publisher;
    }

    public Book(String title, Auther auther, Publisher publisher) {
        this.title = title;
        this.auther = auther;
        this.publisher = publisher;
    }

    public Book() {}
}
