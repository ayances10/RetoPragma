package com.serviceplazoleta.infrastructure.out.jpa.mapper;

import com.serviceplazoleta.domain.model.Order;
import com.serviceplazoleta.infrastructure.out.jpa.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEntityMapper {

    OrderEntity toEntity(Order order);
    Order toOrder(OrderEntity orderEntity);
}
