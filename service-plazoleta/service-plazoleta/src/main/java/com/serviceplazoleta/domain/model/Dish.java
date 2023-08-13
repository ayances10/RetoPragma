package com.serviceplazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private Long id;
    private String name;
    private String price;
    private String description;
    private String urlImage;
    private Boolean active;
    private Restaurant restaurant;
    private Category category;








}
