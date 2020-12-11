package com.poc.photographer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthApiService authApiService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authApiService.signin(loginRequest);
    }

    @PostMapping("/signup")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@Valid @ModelAttribute SignUpRequest signUpRequest) {
        return authApiService.signup(signUpRequest);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changeUserPassword(
            @RequestParam("userId") Long userId,
            @RequestParam("token") String token,
            @RequestParam("password") String password) {
        return authApiService.changeUserPassword(userId, token, password);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestParam("email") String userEmail) {
        return authApiService.resetPassword(userEmail);
    }

}