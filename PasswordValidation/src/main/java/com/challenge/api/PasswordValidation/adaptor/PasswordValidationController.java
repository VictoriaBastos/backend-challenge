package com.challenge.api.PasswordValidation.adaptor;

import com.challenge.api.PasswordValidation.adaptor.dto.PasswordDTO;
import com.challenge.api.PasswordValidation.adaptor.dto.PasswordForm;
import com.challenge.api.PasswordValidation.port.in.PasswordValidationInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/usuario")
public class PasswordValidationController {

    @Autowired
    private PasswordValidationInputPort port;

    @PostMapping("/senha")
    public ResponseEntity<PasswordDTO> validateUserPassword(@RequestBody @Valid PasswordForm passwordForm){
        boolean passwordChecked = port.validatePassword(passwordForm.toDomain());
        try{
            return ResponseEntity.ok().body(new PasswordDTO(passwordChecked));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
