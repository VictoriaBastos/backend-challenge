package com.challenge.api.PasswordValidation.adaptor.dto;

import com.challenge.api.PasswordValidation.core.domain.Password;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasswordForm {
    private String password;

    public Password toDomain(){
        return new Password(this.password);
    }
}
