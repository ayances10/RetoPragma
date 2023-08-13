package com.usuario.serviceusuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;

    private String restaurantId;

    private String employeeId;
}
