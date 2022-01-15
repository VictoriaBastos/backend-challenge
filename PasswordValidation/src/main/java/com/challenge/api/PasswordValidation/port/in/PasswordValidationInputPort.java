package com.challenge.api.PasswordValidation.port.in;

import com.challenge.api.PasswordValidation.core.domain.Password;

public interface PasswordValidationInputPort {
    boolean validatePassword(Password password);
}
