package com.serviceplazoleta.domain.spi;

import com.serviceplazoleta.domain.model.Dish;

public interface IDishPersistencePort {

    Dish saveDish(Dish dish);
    Dish getDishById(Long id);
    Dish getDishByIdRestaurant(Long RestaurantId);
}
