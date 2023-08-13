package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.DishRequestDto;
import com.serviceplazoleta.application.dto.DishUpdateRequestDto;
import com.serviceplazoleta.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {


    @Mapping(target = "restaurant.id", source = "restaurant")
    @Mapping(target = "category.id", source = "category")
    Dish toDish(DishRequestDto dishRequestDto);


    Dish toDishUpdate(DishUpdateRequestDto dishUpdateRequestDto);
}
