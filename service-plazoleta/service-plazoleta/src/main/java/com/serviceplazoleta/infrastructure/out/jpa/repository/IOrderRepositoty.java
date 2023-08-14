package com.serviceplazoleta.infrastructure.out.jpa.repository;

import com.serviceplazoleta.infrastructure.out.jpa.entity.OrderDishEntity;
import com.serviceplazoleta.infrastructure.out.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepositoty extends JpaRepository<OrderEntity, Long>  {


}
