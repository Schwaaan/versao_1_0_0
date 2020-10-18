package com.teste.teste.service.impl;

import com.teste.teste.config.SecurityUtils;
import com.teste.teste.domain.Token;
import com.teste.teste.domain.User;
import com.teste.teste.domain.UserAuthenticated;
import com.teste.teste.domain.dto.TokenDTO;
import com.teste.teste.domain.dto.UserLoginDTO;
import com.teste.teste.domain.dto.ValidateTokenDTO;
import com.teste.teste.repository.TokenRepository;
import com.teste.teste.repository.UserRepository;
import com.teste.teste.service.AuthenticationService;
import com.teste.teste.utils.Assert;
import com.teste.teste.utils.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

import static com.teste.teste.config.SecurityUtils.EXPIRATION_TIME;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecurityUtils securityUtils;
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public UserAuthenticated authentication(UserLoginDTO userLoginDTO) {
        User user = Assert.found(userRepository.findOneByLoginAndPasswordAndDeletedIsFalse(userLoginDTO.getLogin(), userLoginDTO.getPassword()), "User not found");
        return new UserAuthenticated(user.getLogin(), user.getName(), securityUtils.generateToken(user), user.isAdmin(), true);
    }

    @Override
    public ValidateTokenDTO renoveToken(TokenDTO token) {
        return securityUtils.renovarToken(token);
    }
}
