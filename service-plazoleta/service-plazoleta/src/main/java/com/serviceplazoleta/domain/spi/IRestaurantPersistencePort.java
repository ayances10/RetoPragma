package com.serviceplazoleta.domain.spi;

import com.serviceplazoleta.domain.model.Restaurant;

public interface IRestaurantPersistencePort {

    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);
    Restaurant getIdProprietor(Long idProprietor);
    Restaurant getRestaurantByIdPropietario(Long idProprietor);
}
