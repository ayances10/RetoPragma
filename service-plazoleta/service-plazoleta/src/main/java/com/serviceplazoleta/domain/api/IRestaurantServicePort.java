package com.serviceplazoleta.domain.api;

import com.serviceplazoleta.domain.model.Restaurant;

import java.util.Map;

public interface IRestaurantServicePort {

    void saveRestaurant(Restaurant restaurantModel, Long propietarioId);

    Boolean validateAccess(Long userId, String requiredRole, String token);
}
