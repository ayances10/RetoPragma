package com.serviceplazoleta.infrastructure.out.jpa.adapter;

import com.serviceplazoleta.domain.model.Restaurant;
import com.serviceplazoleta.domain.spi.IRestaurantPersistencePort;
import com.serviceplazoleta.infrastructure.out.jpa.entity.RestaurantEntity;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IRestaurantRepository;

import java.util.Optional;

public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    public RestaurantJpaAdapter(IRestaurantRepository restaurantRepository, IRestaurantEntityMapper restaurantEntityMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantEntityMapper = restaurantEntityMapper;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
        return restaurantEntityMapper.toRestaurant(restaurantEntity);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        Optional<RestaurantEntity> optionalRestaurantEntity= restaurantRepository.findById(id);
        RestaurantEntity restaurantEntity = optionalRestaurantEntity.orElse(null);
        return restaurantEntityMapper.toRestaurant(restaurantEntity);
    }

    @Override
    public Restaurant getIdProprietor(Long idProprietor) {

        return null;
    }

    @Override
    public Restaurant getRestaurantByIdPropietario(Long idProprietor) {
        return null;
    }
}
