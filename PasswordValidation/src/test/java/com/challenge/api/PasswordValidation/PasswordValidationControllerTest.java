package com.challenge.api.PasswordValidation;

import com.challenge.api.PasswordValidation.adaptor.dto.PasswordForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PasswordValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void postPassword() throws Exception {
        PasswordForm passwordForm = new PasswordForm("Andy1968*");

        mockMvc.perform(post("/usuario/senha")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(passwordForm)))
                .andExpect(status().isOk());

    }

    @Test
    public void postNullPassword() throws Exception {
        PasswordForm passwordForm = new PasswordForm(null);

        mockMvc.perform(post("/usuario/senha")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(passwordForm)))
                .andExpect(status().isBadRequest());
    }

}

