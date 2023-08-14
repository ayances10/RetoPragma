package com.serviceplazoleta.domain.api;

import com.serviceplazoleta.domain.model.Order;

public interface IOrderServicePort {

    void saveOrder(Order order);

    Boolean validateAccess(Long userId, String requiredRole, String token);

}
