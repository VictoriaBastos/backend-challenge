package com.challenge.api.PasswordValidation.core.usecase;

import com.challenge.api.PasswordValidation.core.domain.Password;
import com.challenge.api.PasswordValidation.port.in.PasswordValidationInputPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordValidationService implements PasswordValidationInputPort {
    @Override
    public boolean validatePassword(Password password) {
        String userPassword = password.getPassword();

        boolean hasDigit = userPassword.replaceAll("[0-9]","").length() != userPassword.length();
        boolean hasLowerCase = userPassword.replaceAll("[a-z]","").length() != userPassword.length();
        boolean hasUpperCase = userPassword.replaceAll("[A-Z]","").length() != userPassword.length();
        boolean hasSpecialCharacter = userPassword.replaceAll("[!@#$%^&*()-+]","").length() != userPassword.length();

        if(!hasDigit || !hasLowerCase || !hasUpperCase || !hasSpecialCharacter){
            return false;
        }

        // Checking for duplicated characters
        List<String> groupOfCharacters = new ArrayList<>();
        for(String ch : userPassword.split("")){
            if(groupOfCharacters.contains(ch)){
                return false;
            }
            groupOfCharacters.add(ch);
        }

        // Checking for length and blank spaces
        if(userPassword.length() < 9 || userPassword.indexOf(" ") >= 0 ){
            return false;
        }

        return true;
    }
}
