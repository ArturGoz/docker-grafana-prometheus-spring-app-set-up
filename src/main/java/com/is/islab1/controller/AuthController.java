package com.is.islab1.controller;

import com.is.islab1.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public String authorize() {
        authService.authorize();
        return "User authorized successfully!";
    }

    @GetMapping("/status")
    public String status() {
        return authService.isAuthorized()
                ? "User is authorized"
                : "User is NOT authorized";
    }
}
