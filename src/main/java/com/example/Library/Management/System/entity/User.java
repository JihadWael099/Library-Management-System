package com.example.Library.Management.System.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username" ,length = 11)
    private String username;

    @Column(name = "email" , length = 45)
    private String email;

    @Column(name = "password" , length = 45)
    private String password;


    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }
}
