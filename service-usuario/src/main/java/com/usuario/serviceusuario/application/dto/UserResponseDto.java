package com.usuario.serviceusuario.application.dto;

import com.usuario.serviceusuario.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String name;
    private String lastName;
    private String documentId;
    private String phoneNumber;
    private String mail;
    private String password;
    private Role role;
}
