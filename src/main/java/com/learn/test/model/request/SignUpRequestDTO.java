package com.learn.test.model.request;


import lombok.*;

@Data
public class SignUpRequestDTO {

    private String username;

    private String phoneNumber;

    private String password;

    private String gender;

    private Boolean isActive;

    private String roleCode;


}
