package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.RestaurantRequestDto;

import java.util.Map;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto, Long propietarioId);

    void validateAccess(Long userId, String requiredRole, String token) throws Exception;
}
