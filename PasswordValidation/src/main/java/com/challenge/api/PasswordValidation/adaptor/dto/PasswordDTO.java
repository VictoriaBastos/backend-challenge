package com.challenge.api.PasswordValidation.adaptor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasswordDTO {
    @JsonProperty("senha validada")
    boolean validPassword;

    public PasswordDTO(boolean passwordChecked){
        this.validPassword = passwordChecked;
    }
}
