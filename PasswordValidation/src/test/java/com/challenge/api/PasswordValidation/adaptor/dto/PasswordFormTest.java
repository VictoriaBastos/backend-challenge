package com.challenge.api.PasswordValidation.adaptor.dto;

import com.challenge.api.PasswordValidation.core.domain.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class PasswordFormTest {

    @Test
    public void toDomain() {
        PasswordForm passwordForm = new PasswordForm("Andy1968*");
        Password userPassword = passwordForm.toDomain();
        Assertions.assertEquals(userPassword.getPassword(),passwordForm.getPassword());
    }
}