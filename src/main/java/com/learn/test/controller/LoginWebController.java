package com.learn.test.controller;

import com.learn.test.model.request.LoginRequestDTO;
import com.learn.test.model.request.SignUpRequestDTO;
import com.learn.test.model.response.APIResponse;
import com.learn.test.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginWebController {

    private final LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) throws Exception {

        APIResponse apiResponse = loginService.signUp(signUpRequestDTO);

        return ResponseEntity
                .status((HttpStatus) apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {

        APIResponse apiResponse = loginService.login(loginRequestDTO);

        return ResponseEntity
                .status((HttpStatus) apiResponse.getStatus())
                .body(apiResponse);
    }
}
