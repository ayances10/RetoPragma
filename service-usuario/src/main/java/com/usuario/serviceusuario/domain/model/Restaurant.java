package com.usuario.serviceusuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private Long id;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String logoUrl;
    private Long idProprietor;
}
