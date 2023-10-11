package com.emailverification;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final EmailVerificationService emailVerificationService;

    @GetMapping("/send-code")
    public ResponseEntity<String> sendCode(@RequestParam String email) {
        emailVerificationService.sendCodeToEmail(email);
        return ResponseEntity.ok("success");
    }
}


