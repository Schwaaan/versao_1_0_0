package com.teste.teste.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "nome")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String password;
    @Column(name = "administrador")
    private boolean admin;

    public User() {
    }

    public User(Integer id, String login, String password, String name, boolean admin, boolean deleted) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.deleted = deleted;
    }
}
