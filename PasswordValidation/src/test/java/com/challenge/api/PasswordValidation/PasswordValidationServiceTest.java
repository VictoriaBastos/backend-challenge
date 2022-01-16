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
}
