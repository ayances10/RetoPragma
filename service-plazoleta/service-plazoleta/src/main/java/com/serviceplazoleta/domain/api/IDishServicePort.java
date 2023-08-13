package com.serviceplazoleta.domain.api;

import com.serviceplazoleta.domain.model.Dish;

import javax.servlet.http.HttpServletRequest;

public interface IDishServicePort {

    void saveDish(Dish dish, Long restaurantId,HttpServletRequest request);
    Dish getDishById(Long id);

    void updateDish(Long id, Dish dish, Long restaurantId, HttpServletRequest request, Long propietarioId);

    Boolean validateAccess(Long userId, String requiredRole, String token);
}
