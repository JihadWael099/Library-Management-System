package com.example.Library.Management.System.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Length;

import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "publisher_id", length = 11)
    private int publisherId;

    @Column(name = "name" , length = 50)
    private String name;


    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(int publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }
    public Publisher() {}

    public Publisher(String name) {
        this.name = name;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
