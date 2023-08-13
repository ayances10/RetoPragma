package com.serviceplazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String name;
    private String lastName;
    private String documentId;
    private String phoneNumber;
    private String mail;
    private String password;
    private Role role;
}
