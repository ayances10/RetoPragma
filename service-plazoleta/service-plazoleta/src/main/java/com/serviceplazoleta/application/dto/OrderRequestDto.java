package com.serviceplazoleta.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderRequestDto {

    @NotNull(message = "La lista de platos no permite ser nula")
    private List<OrderDishRequestDto> dishes;
    @NotNull(message = "El id del retaurante no puede ser nulo.")
    private Long idRestaurant;
}
