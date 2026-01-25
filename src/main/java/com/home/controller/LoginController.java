package com.home.controller;

import com.home.dto.AuthPayload;
import com.home.dto.AuthRequest;
import com.home.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final AuthService authService;
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthPayload login(@RequestBody AuthRequest request) {
        return authService.validateUser(
                request.getEmail(),
                request.getPassword()
        );
    }
}
