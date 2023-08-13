package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.RestaurantRequestDto;
import com.serviceplazoleta.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {

    Restaurant toRestaurant(RestaurantRequestDto restaurantRequestDto);

    RestaurantRequestDto toRequest(Restaurant restaurant);
}
