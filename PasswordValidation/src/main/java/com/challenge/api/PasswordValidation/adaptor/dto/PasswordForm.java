package com.challenge.api.PasswordValidation.adaptor.dto;

import com.challenge.api.PasswordValidation.core.domain.Password;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordForm {
    private String password;

    public Password toDomain(){
        return new Password(this.password);
    }
}
