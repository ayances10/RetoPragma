package com.serviceplazoleta.application.dto;

import com.serviceplazoleta.domain.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDishResponseDto {
    
    private Long id;
    private String name;
    private String price;
    private String description;
    private String urlImage;
    private Category category;
    private  String quantity;
}
