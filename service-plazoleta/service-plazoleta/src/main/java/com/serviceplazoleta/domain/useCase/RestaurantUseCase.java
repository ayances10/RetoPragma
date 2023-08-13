package com.serviceplazoleta.domain.useCase;

import com.serviceplazoleta.domain.api.IRestaurantServicePort;
import com.serviceplazoleta.domain.api.exception.OwnerMustOnlyOwnARestaurantException;
import com.serviceplazoleta.domain.model.Restaurant;
import com.serviceplazoleta.domain.spi.IRestaurantPersistencePort;
import com.serviceplazoleta.domain.spi.feignclient.IUserFeignClientPort;

public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserFeignClientPort userFeignClientPort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IUserFeignClientPort userFeignClientPort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userFeignClientPort = userFeignClientPort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant, Long propietarioId) {
        Restaurant restaurant1 = restaurantPersistencePort.getRestaurantByIdPropietario(propietarioId);
        if (restaurant1 != null) throw new OwnerMustOnlyOwnARestaurantException();
        restaurantPersistencePort.saveRestaurant(restaurant);
    }

    public Boolean validateAccess(Long userId, String requiredRole, String token) {
        return userFeignClientPort.validateUserId(userId, requiredRole, token);
    }
}
