package com.teste.teste.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ResponseDTO implements Serializable {

    private String message;
    private LocalDateTime time;

    public ResponseDTO() {
    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    public static ResponseDTO of(String message) {
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage(message);
        dto.setTime(LocalDateTime.now());
        return dto;
    }
}
