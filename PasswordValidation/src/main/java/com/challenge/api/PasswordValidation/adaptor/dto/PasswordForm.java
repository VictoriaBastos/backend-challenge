package com.challenge.api.PasswordValidation.adaptor.dto;

import com.challenge.api.PasswordValidation.core.domain.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PasswordForm {
    @NotNull(message = "Password is Null")
    private String password;

    public Password toDomain(){
        return new Password(this.password);
    }
}
