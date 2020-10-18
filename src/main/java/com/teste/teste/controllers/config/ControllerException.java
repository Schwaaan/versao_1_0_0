package com.teste.teste.controllers.config;

import com.teste.teste.domain.dto.ResponseDTO;
import com.teste.teste.utils.NotFoundException;
import com.teste.teste.utils.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDTO notFound(NotFoundException ex) {
        return ResponseDTO.of(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO badRequest(IllegalArgumentException ex) {
        return ResponseDTO.of(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseDTO badRequest(UnauthorizedException ex) {
        return ResponseDTO.of(ex.getMessage());
    }

}
