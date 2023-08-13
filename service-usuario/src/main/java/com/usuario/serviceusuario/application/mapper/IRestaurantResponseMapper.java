package com.usuario.serviceusuario.application.mapper;

import com.usuario.serviceusuario.application.dto.RestaurantResponseDto;
import com.usuario.serviceusuario.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toResponse(Restaurant restaurant);
    Restaurant toRestaurant(RestaurantResponseDto restaurantResponseDto);
}
