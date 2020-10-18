package com.teste.teste.service.impl;

import com.teste.teste.domain.Token;
import com.teste.teste.repository.TokenRepository;
import com.teste.teste.service.TokenService;
import com.teste.teste.utils.Assert;
import com.teste.teste.utils.UnauthorizedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    public static final String TOKEN_PREFIX = "Bearer ";

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token validateToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            throw new UnauthorizedException("Token está vazio");
        }
        authorization = authorization.replace(TOKEN_PREFIX, StringUtils.EMPTY);
        Token token1 = Assert.found(tokenRepository.findOneByToken(authorization), "Token não encontrado");
        if (token1.isExpiration()) {
            throw new UnauthorizedException("Token Expirado");
        }
        return token1;
    }

    @Override
    public void validateTokenAndIsAdmin(HttpServletRequest request) {
        Token token = this.validateToken(request);
        if(!token.isAdmin()){
            throw new UnauthorizedException("Usuário não é administrador");
        }
    }
}
