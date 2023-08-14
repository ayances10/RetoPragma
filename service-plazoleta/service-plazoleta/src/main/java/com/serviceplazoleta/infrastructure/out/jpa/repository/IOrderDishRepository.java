package com.serviceplazoleta.infrastructure.out.jpa.repository;

import com.serviceplazoleta.infrastructure.out.jpa.entity.OrderDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDishRepository extends JpaRepository<OrderDishEntity, Long> {
}
