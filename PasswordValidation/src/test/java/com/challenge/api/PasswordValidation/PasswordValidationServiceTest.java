package com.challenge.api.PasswordValidation;

import com.challenge.api.PasswordValidation.core.domain.Password;
import com.challenge.api.PasswordValidation.core.usecase.PasswordValidationService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PasswordValidationServiceTest {

    @TestConfiguration
    static class PasswordValidationServiceTestConfiguration{
        @Bean
        public PasswordValidationService passwordService(){
            return new PasswordValidationService();
        }
    }

    @Autowired
    PasswordValidationService passwordService;

    @Test
    public void passwordValidationTest(){
        Password passwordUser = new Password("Andy1968*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,true);
    }

    @Test
    public void passwordWithoutDigit(){
        Password passwordUser = new Password("ANDYlbst*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }

    @Test
    public void passwordWithoutLowerCase(){
        Password passwordUser = new Password("ANDY1968*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }

    @Test
    public void passwordWithoutUpperCase(){
        Password passwordUser = new Password("andy1968*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }

    @Test
    public void passwordWithoutSpecialCharacter(){
        Password passwordUser = new Password("Andy1968S");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }

    @Test
    public void passwordWithoutDuplicatedCharacters(){
        Password passwordUser = new Password("AAndy1968*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }

    @Test
    public void passwordLengthIsNotEnough(){
        Password passwordUser = new Password("Andy196*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }

    @Test
    public void passwordWithoutBlankSpaces(){
        Password passwordUser = new Password("Andy 1968*");
        boolean validPassword = passwordService.validatePassword(passwordUser);

        Assertions.assertEquals(validPassword,false);
    }
}
