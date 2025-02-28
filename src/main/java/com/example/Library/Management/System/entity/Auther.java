package com.example.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "auther")
public class Auther {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auther_id" , length = 11)
    private int autherId;

    @Column(name = "name" , length = 50)
    private String name;

    @OneToMany(mappedBy = "auther")
    private Set<Book>books;

    public Auther(String name) {
        this.name = name;
    }
    public Auther() {

    }
    public Auther(int autherId, String name) {
        this.autherId = autherId;
        this.name = name;
    }

    public int getAutherId() {
        return autherId;
    }

    public void setAutherId(int autherId) {
        this.autherId = autherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}