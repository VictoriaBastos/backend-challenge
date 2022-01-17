package com.challenge.PasswordValidation.adaptor.dto;

import com.challenge.PasswordValidation.core.domain.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordForm {
    @NotNull(message = "Password is Null")
    private String password;

    public Password toDomain(){
        return new Password(this.password);
    }
}
