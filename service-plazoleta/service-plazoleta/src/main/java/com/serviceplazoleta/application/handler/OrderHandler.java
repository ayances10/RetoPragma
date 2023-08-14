package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.OrderRequestDto;
import com.serviceplazoleta.application.mapper.IOrderRequestMapper;
import com.serviceplazoleta.domain.api.IOrderServicePort;
import com.serviceplazoleta.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderHandler implements IOrderHandler{

    private final IOrderServicePort orderServicePort;
    private final IOrderRequestMapper orderRequestMapper;

    @Override
    public void saveOrder(OrderRequestDto orderRequestDto,Long propietarioId) {
        Order order = orderRequestMapper.toOrder(orderRequestDto);
        orderServicePort.saveOrder(order);
    }

    @Override
    public void validateAccess(Long userId, String requiredRole, String token) throws Exception {
        Boolean hasValidAcces = orderServicePort.validateAccess(userId,requiredRole,token);
        if (!hasValidAcces){
            throw new Exception("User has no access to this resource.");
        }
    }
}
