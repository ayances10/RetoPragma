package com.serviceplazoleta.infrastructure.out.jpa.adapter;

import com.serviceplazoleta.domain.model.Dish;
import com.serviceplazoleta.domain.spi.IDishPersistencePort;
import com.serviceplazoleta.infrastructure.exception.NoDataFoundException;
import com.serviceplazoleta.infrastructure.out.jpa.entity.DishEntity;
import com.serviceplazoleta.infrastructure.out.jpa.entity.RestaurantEntity;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IDishRepository;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishJpaAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;


    public DishJpaAdapter(IDishRepository dishRepository, IDishEntityMapper dishEntityMapper) {
        this.dishRepository = dishRepository;
        this.dishEntityMapper = dishEntityMapper;

    }

    @Override
    public Dish saveDish(Dish dish) {
        DishEntity dishEntity = dishRepository.save(dishEntityMapper.toEntity(dish));
        return dishEntityMapper.toDish(dishEntity);
    }

    @Override
    public Dish getDishById(Long id) {
        Optional<DishEntity> optionalDishEntity= dishRepository.findById(id);
        DishEntity dishEntity = optionalDishEntity.orElse(null);
        return dishEntityMapper.toDish(dishEntity);
    }

    @Override
    public Dish getDishByIdRestaurant(Long RestaurantId) {
        return null;
    }

    @Override
    public List<Dish> getAllDish() {
        List<DishEntity> dishEntitiesList = dishRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (dishEntitiesList.isEmpty()){
            throw new NoDataFoundException();
        }
        return dishEntityMapper.toDishList(dishEntitiesList);
    }

    @Override
    public List<Dish> findAllByRestaurantId(Long idRestaurant, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return dishRepository.findAllByRestaurantId(idRestaurant,pageable)
                .stream()
                .map(dishEntity -> dishEntityMapper.toDish(dishEntity))
                .filter(dishEntity -> dishEntity.getActive())
                .collect(Collectors.toList());
    }
}
