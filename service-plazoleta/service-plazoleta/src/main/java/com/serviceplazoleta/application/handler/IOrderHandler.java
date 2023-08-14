package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.OrderRequestDto;

public interface IOrderHandler {

    void saveOrder(OrderRequestDto orderRequestDto,Long propietarioId);
    void validateAccess(Long userId, String requiredRole, String token) throws Exception;
}
