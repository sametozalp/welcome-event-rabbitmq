package com.ozalp.publisher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public ResponseEntity<?> register(@RequestParam String user, @RequestParam String email) {
        registrationService.registerUser(user, email);
        return ResponseEntity.ok().body("");
    }
}