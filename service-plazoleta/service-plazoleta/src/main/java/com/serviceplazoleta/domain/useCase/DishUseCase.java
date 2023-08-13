package com.serviceplazoleta.domain.useCase;

import com.serviceplazoleta.application.handler.IDishHandler;
import com.serviceplazoleta.application.handler.IRestaurantHandler;
import com.serviceplazoleta.domain.api.IDishServicePort;
import com.serviceplazoleta.domain.api.exception.DishNotExistException;
import com.serviceplazoleta.domain.api.exception.RestaurantNotExistExeception;
import com.serviceplazoleta.domain.model.Dish;
import com.serviceplazoleta.domain.model.Restaurant;
import com.serviceplazoleta.domain.spi.IDishPersistencePort;
import com.serviceplazoleta.domain.spi.IRestaurantPersistencePort;
import com.serviceplazoleta.domain.spi.feignclient.IUserFeignClientPort;
import com.serviceplazoleta.infrastructure.exception.DifferentOwnerException;
import com.serviceplazoleta.infrastructure.out.jpa.entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort dishPersistencePort;
    private final IUserFeignClientPort userFeignClientPort;
    private final IRestaurantPersistencePort restaurantPersistencePort;


    @Override
    public void saveDish(Dish dish, Long restaurantId, HttpServletRequest request) {
        Dish dish1 = dishPersistencePort.getDishByIdRestaurant(restaurantId);
        if (dish1 != null) throw new RestaurantNotExistExeception();
        Long userId = Long.valueOf((String) request.getAttribute("userId"));
        Long idProprietorRestaurant =  restaurantPersistencePort.getRestaurantById(dish.getRestaurant().getId()).getIdProprietor();

        System.out.println(userId + " " + idProprietorRestaurant);
        if (userId != idProprietorRestaurant) throw new DifferentOwnerException();
        dish.setActive(true);
        dishPersistencePort.saveDish(dish);
    }
    @Override
    public Dish getDishById(Long id) {
        return dishPersistencePort.getDishById(id);
    }
    @Override
    public void updateDish(Long id, Dish dish, Long restaurantId, HttpServletRequest request, Long propietarioId) {
        Dish dish1 = dishPersistencePort.getDishById(id);
        if (dish1 == null) throw new DishNotExistException();

        Dish dish2 = dishPersistencePort.getDishByIdRestaurant(restaurantId);
        if (dish2 != null) throw new RestaurantNotExistExeception();

        Long userId = Long.valueOf((String) request.getAttribute("userId"));
        Long idProprietorRestaurant = dish1.getRestaurant().getIdProprietor();

        System.out.println("user id : "+userId + " id Propietario: "+idProprietorRestaurant);
        if (userId != idProprietorRestaurant) throw new DifferentOwnerException();
        dish1.setPrice(dish.getPrice());
        dish1.setDescription(dish.getDescription());
        dishPersistencePort.saveDish(dish1);
    }


    @Override
    public Boolean validateAccess(Long userId, String requiredRole, String token) {
        return userFeignClientPort.validateUserId(userId,requiredRole,token);
    }


}
