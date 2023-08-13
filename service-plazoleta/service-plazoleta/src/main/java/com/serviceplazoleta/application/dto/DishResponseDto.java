package com.serviceplazoleta.application.dto;

import com.serviceplazoleta.domain.model.Category;
import com.serviceplazoleta.domain.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponseDto {

    private Long id;
    private String name;
    private String price;
    private String description;
    private String urlImage;
    private Boolean active;
    private Restaurant restaurant;
    private Category category;
}
