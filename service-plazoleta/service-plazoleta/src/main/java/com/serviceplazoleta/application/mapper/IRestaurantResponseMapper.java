package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.RestaurantResponseDto;
import com.serviceplazoleta.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toResponse(Restaurant restaurant);
}
