package com.serviceplazoleta.infrastructure.out.feignclient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {

    private Long id;
    private String nombre;
    private String descripcion;

}
