package com.serviceplazoleta.infrastructure.out.jpa.adapter;

import com.serviceplazoleta.domain.model.Restaurant;
import com.serviceplazoleta.domain.spi.IRestaurantPersistencePort;
import com.serviceplazoleta.infrastructure.exception.NoDataFoundException;
import com.serviceplazoleta.infrastructure.out.jpa.entity.RestaurantEntity;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<RestaurantEntity> restaurantEntityList = (List<RestaurantEntity>) restaurantRepository.findAll();
        if (restaurantEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantList(restaurantEntityList);
    }

    @Override
    public List<Restaurant> getRestaurantsWhithPagination(Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"name"));
        Page<RestaurantEntity> restaurantEntityPage = restaurantRepository.findAll(pageable);
        List<RestaurantEntity> restaurantEntityList = restaurantEntityPage.getContent();
        if (restaurantEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantList(restaurantEntityList);
    }
}
