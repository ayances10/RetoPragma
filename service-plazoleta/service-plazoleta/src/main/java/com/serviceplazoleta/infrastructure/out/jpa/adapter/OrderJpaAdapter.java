package com.serviceplazoleta.infrastructure.out.jpa.adapter;

import com.serviceplazoleta.domain.model.Order;
import com.serviceplazoleta.domain.spi.IOrderPersistencePort;
import com.serviceplazoleta.infrastructure.out.jpa.entity.OrderEntity;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IOrderEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IOrderRepositoty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderJpaAdapter implements IOrderPersistencePort {

    private final IOrderRepositoty orderRepositoty;
    private final IOrderEntityMapper orderEntityMapper;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = orderRepositoty.save(orderEntityMapper.toEntity(order));
        return orderEntityMapper.toOrder(orderEntity);
    }
}
