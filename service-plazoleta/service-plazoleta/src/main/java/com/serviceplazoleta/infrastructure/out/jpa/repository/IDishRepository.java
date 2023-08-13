package com.serviceplazoleta.infrastructure.out.jpa.repository;

import com.serviceplazoleta.infrastructure.out.jpa.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDishRepository extends JpaRepository<DishEntity, Long> {

    Page<DishEntity> findAllByRestaurantId(Long idRestaurant, Pageable page);
}
