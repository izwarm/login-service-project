package com.learn.test.model.users;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String username;

    private String password;

    private Boolean isActive = true;

    private String phoneNumber;

    private String gender;

    private LocalDate loginAt;

    private LocalDate createAt;

    private LocalDate updateAt;


}
