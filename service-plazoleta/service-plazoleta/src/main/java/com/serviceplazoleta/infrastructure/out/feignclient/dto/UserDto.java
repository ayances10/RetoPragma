package com.serviceplazoleta.infrastructure.out.feignclient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

    private long id;
    private String name;
    private String lastName;
    private String documentId;
    private String phoneNumber;
    private String mail;
    private String password;
    private RoleDto role;
}
