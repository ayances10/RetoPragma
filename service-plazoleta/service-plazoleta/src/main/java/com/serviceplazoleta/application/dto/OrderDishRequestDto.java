package com.serviceplazoleta.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrderDishRequestDto {

    @NotNull(message = "Campo id del plato no permite nulos.")
    private Long idDishes;
    @NotNull(message = "La cantidad de platos no permite nulos.")
    private Long quantity;
}
