package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.TokenDTO;
import com.devsuperior.dscommerce.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public TokenDTO login(@RequestParam String username, @RequestParam String password) {
        return authService.authenticate(username, password);
    }
}
