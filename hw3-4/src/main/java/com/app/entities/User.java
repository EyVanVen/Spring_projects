package com.app.entities;

import lombok.Data;
import org.checkerframework.common.aliasing.qual.Unique;


import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    @Unique
    private String email;

    public User(String login, @Unique String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User() {}

    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
