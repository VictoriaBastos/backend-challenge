package com.challenge.api.PasswordValidation.adaptor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordDTO {
    @JsonProperty("senha validada:")
    private boolean passwordVerified;
}
