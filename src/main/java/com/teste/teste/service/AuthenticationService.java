package com.teste.teste.service;

import com.teste.teste.domain.UserAuthenticated;
import com.teste.teste.domain.dto.TokenDTO;
import com.teste.teste.domain.dto.UserLoginDTO;
import com.teste.teste.domain.dto.ValidateTokenDTO;

public interface AuthenticationService {
    
    UserAuthenticated authentication(UserLoginDTO userLoginDTO);

    ValidateTokenDTO renoveToken(TokenDTO token);
}
