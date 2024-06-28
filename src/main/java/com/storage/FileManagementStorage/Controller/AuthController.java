package com.storage.FileManagementStorage.Controller;

import com.storage.FileManagementStorage.Service.AuthService;
import com.storage.FileManagementStorage.dtos.JWTAuthResponse;
import com.storage.FileManagementStorage.dtos.LoginDto;
import com.storage.FileManagementStorage.dtos.RegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //build login rest api

    @PostMapping("/login")
    // @PostMapping(value = {"/login", "/signin"})  //this is how we can have multiple endpoints for the same method. with "value" attribute
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) { //changed the return type from String to jwtAuthResponse
//        String response = authService.login(loginDto);
//        return ResponseEntity.ok(response);


        String token = authService.login(loginDto);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    //build register rest api
    //@PostMapping("/register")
    @PostMapping(value = {"/register", "/signup"})
    //this is how we can have multiple endpoints for the same method. with "value" attribute
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

