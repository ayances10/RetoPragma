package com.serviceplazoleta.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {

    private Long id;
    private Long idClient;
    private Long idChef;
    private Date date;
    private List<OrderDishResponseDto> orderDishes;
}
