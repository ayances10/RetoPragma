package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.RestaurantPaginationResponseDto;
import com.serviceplazoleta.application.dto.RestaurantRequestDto;
import com.serviceplazoleta.application.dto.RestaurantResponseDto;

import java.util.List;
import java.util.Map;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto, Long propietarioId);

    RestaurantResponseDto getRestaurantById(Long id);

    RestaurantResponseDto getRestaurantByIdProprietor(Long idProprietor);

    List<RestaurantResponseDto> getAllRestaurants();

    List<RestaurantPaginationResponseDto> getRestaurantPaginationResponseDto(Integer page, Integer size);

    void validateAccess(Long userId, String requiredRole, String token) throws Exception;
}
