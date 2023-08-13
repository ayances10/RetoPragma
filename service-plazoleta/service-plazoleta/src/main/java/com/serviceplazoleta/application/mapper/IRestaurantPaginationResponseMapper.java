package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.RestaurantPaginationResponseDto;
import com.serviceplazoleta.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantPaginationResponseMapper {

    List<RestaurantPaginationResponseDto> toResponseListPagination(List<Restaurant> restaurantList);
}
