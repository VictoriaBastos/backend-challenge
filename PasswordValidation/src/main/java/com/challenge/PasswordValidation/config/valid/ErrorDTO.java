package com.challenge.PasswordValidation.config.valid;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.List;

@Data
public class ErrorDTO {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ErrorDTO(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ErrorDTO(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
