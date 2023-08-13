package com.serviceplazoleta.domain.spi;

import com.serviceplazoleta.domain.model.Restaurant;

import java.util.List;

public interface IRestaurantPersistencePort {

    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);
    Restaurant getIdProprietor(Long idProprietor);
    Restaurant getRestaurantByIdPropietario(Long idProprietor);

    List<Restaurant> getAllRestaurant();

    List<Restaurant> getRestaurantsWhithPagination(Integer page, Integer size);
}
