package com.teste.teste.domain;

import lombok.Data;

@Data
public class UserAuthenticated {

    private String login;
    private String name;
    private String token;
    private boolean admin;
    private boolean authenticated;

    public UserAuthenticated(String login, String name, String token, boolean admin, boolean authenticated) {
        this.login = login;
        this.name = name;
        this.token = token;
        this.admin = admin;
        this.authenticated = authenticated;
    }
}
