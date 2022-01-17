package com.challenge.PasswordValidation.port.in;

import com.challenge.PasswordValidation.core.domain.Password;

public interface PasswordValidationInputPort {
    boolean validatePassword(Password password);
}
