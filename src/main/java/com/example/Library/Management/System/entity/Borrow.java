package com.example.Library.Management.System.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrow_id")
    private int id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @JoinColumn(name = "borrowDate")
    private LocalDate borrowDate;

    @JoinColumn(name = "returnDate")
    private LocalDate returnDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Borrow(Book book, User user, LocalDate borrowDate, LocalDate returnDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
    public Borrow() {}
}
