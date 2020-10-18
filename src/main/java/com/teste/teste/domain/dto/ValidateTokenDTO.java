package com.teste.teste.domain.dto;

import lombok.Data;

@Data
public class ValidateTokenDTO {

    private String message;
    private boolean isRenew;

    public ValidateTokenDTO(boolean isRenew,String message) {
        this.message = message;
        this.isRenew = isRenew;
    }
}
