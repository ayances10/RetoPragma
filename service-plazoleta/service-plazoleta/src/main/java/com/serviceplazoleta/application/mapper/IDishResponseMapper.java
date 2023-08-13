package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.DishResponseDto;
import com.serviceplazoleta.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishResponseMapper {

    DishResponseDto toResponse(Dish dish);

    //List<DishResponseDto> toResponseList(List<Dish> dishList);

}
