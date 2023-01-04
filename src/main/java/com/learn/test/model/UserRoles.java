package com.learn.test.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_role")
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long userRoleId;

    private Long userId;

    private String roleCode;

}
