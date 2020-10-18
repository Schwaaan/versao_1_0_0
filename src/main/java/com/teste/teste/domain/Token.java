package com.teste.teste.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
public class Token {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "expiration")
    private Date expiration;
    @Column(name = "administrador")
    private boolean admin;


    public Token() {
    }

    public Token(String token) {
        this.token = token;
    }

    public boolean isExpiration() {
        return expiration.before(Date.from(Instant.now()));
    }

    public Token(String token, Date expiration, boolean admin) {
        this.token = token;
        this.expiration = expiration;
        this.admin = admin;
    }
}
