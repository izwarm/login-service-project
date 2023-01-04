package com.learn.test.service;

import com.learn.test.model.request.LoginRequestDTO;
import com.learn.test.model.request.SignUpRequestDTO;
import com.learn.test.model.response.APIResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {


    APIResponse signUp(SignUpRequestDTO signUpRequestDTO) throws Exception;

    APIResponse login(LoginRequestDTO loginRequestDTO);
}
