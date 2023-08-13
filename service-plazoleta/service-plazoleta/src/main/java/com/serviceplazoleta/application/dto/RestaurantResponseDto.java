package com.serviceplazoleta.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDto {

    private Long id;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String logoUrl;
    private Long idProprietor;
}
