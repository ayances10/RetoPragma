package com.serviceplazoleta.application.dto;

import com.serviceplazoleta.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private long id;
    private String name;
    private String lastName;
    private String documentId;
    private String phoneNumber;
    private String mail;
    private String password;
    private Role role;
}
