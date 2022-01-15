package com.challenge.api.PasswordValidation.core.usecase;

import com.challenge.api.PasswordValidation.core.domain.Password;
import com.challenge.api.PasswordValidation.port.in.PasswordValidationInputPort;

public class PasswordValidationService implements PasswordValidationInputPort {
    @Override
    public boolean validatePassword(Password password) {
        String userPassword = password.getPassword();

        boolean hasDigit = userPassword.replaceAll("[0-9]","").length() != userPassword.length();
        boolean hasLowerCase = userPassword.replaceAll("[a-z]","").length() != userPassword.length();
        boolean hasUpperCase = userPassword.replaceAll("[A-Z]","").length() != userPassword.length();
        boolean hasSpecialCharacter = userPassword.replaceAll("[!@#$%^&*()-+]","").length() != userPassword.length();
        boolean hasEnoughCharacters = userPassword.length() >= 9;
        boolean noBlankSpace = userPassword.indexOf(" ") < 0;

        if(hasDigit && hasLowerCase && hasUpperCase && hasSpecialCharacter && hasEnoughCharacters && noBlankSpace){
            return true;
        }
        return false;
    }
}
