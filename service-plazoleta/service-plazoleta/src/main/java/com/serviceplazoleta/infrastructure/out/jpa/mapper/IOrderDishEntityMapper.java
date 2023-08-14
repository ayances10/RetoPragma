package com.serviceplazoleta.infrastructure.out.jpa.mapper;

import com.serviceplazoleta.domain.model.Order;
import com.serviceplazoleta.domain.model.OrderDish;
import com.serviceplazoleta.infrastructure.out.jpa.entity.OrderDishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "string",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderDishEntityMapper {

    OrderDishEntity toEntity(OrderDish orderDish);
    List<OrderDish> toOrderDishModel(List<OrderDishEntity> orderDishEntityList);
}
