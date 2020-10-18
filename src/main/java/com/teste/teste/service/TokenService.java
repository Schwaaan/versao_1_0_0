package com.teste.teste.service;

import com.teste.teste.domain.Token;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    Token validateToken(HttpServletRequest request);

    void validateTokenAndIsAdmin(HttpServletRequest request);
}
