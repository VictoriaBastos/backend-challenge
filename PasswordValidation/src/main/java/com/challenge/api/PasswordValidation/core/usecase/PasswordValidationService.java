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

        // Checking if hasDigit, hasLowerCase, hasUpperCase, hasSpecialCharacter
        String[] myRegexGroup = {"[0-9]","[a-z]","[A-Z]","[!@#$%^&*()-+]"};
        for(String myRegex : myRegexGroup){
            if(userPassword.replaceAll(myRegex,"").length() == userPassword.length()){
                return false;
            }
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
