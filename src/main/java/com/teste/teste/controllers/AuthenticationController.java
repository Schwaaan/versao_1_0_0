package com.teste.teste.controllers;

import com.teste.teste.domain.UserAuthenticated;
import com.teste.teste.domain.dto.TokenDTO;
import com.teste.teste.domain.dto.UserLoginDTO;
import com.teste.teste.domain.dto.ValidateTokenDTO;
import com.teste.teste.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/v1/usuario/authenticar")
    public UserAuthenticated userAuthenticated(@RequestBody UserLoginDTO userLoginDTO) {
        return authenticationService.authentication(userLoginDTO);
    }

    @GetMapping("/v1/usuario/renovar-ticket")
    public ValidateTokenDTO renewToken(@RequestBody TokenDTO token) {
        return authenticationService.renoveToken(token);
    }
}
