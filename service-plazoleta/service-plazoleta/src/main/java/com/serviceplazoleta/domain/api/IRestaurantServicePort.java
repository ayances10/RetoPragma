package com.serviceplazoleta.domain.api;

import com.serviceplazoleta.domain.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface IRestaurantServicePort {

    void saveRestaurant(Restaurant restaurantModel, Long propietarioId);

    Restaurant getRestaurantById(Long id);

    Restaurant getRestaurantByIdProprietor(Long idProprietor);

    List<Restaurant> getAllRestaurant();

    List<Restaurant> getRestaurantsWhithPagination(Integer page, Integer siza);

    Boolean validateAccess(Long userId, String requiredRole, String token);
}
