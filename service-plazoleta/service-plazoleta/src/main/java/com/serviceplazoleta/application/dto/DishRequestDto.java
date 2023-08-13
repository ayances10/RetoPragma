package com.serviceplazoleta.application.dto;

import com.serviceplazoleta.domain.model.Category;
import com.serviceplazoleta.domain.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class DishRequestDto {

    private Long id;
    @NotBlank(message = "El nombre es requerido")
    private String name;
    @NotBlank(message = "El precio es requerido")
    @Pattern(regexp = "^[1-9]\\d*$", message = "El precio debe ser un número entero positivo mayor a cero")
    private String price;
    @NotBlank(message = "La descripcion es requerida")
    private String description;
    @NotBlank(message = "La urlImagen es requerida")
    private String urlImage;

    private Boolean active;
    private Long restaurant;
    private Long category;
}
