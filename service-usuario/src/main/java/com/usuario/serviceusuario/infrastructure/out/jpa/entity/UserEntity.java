package com.usuario.serviceusuario.infrastructure.out.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String mail;
    private String documentId;
    private String phoneNumber;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;
}
