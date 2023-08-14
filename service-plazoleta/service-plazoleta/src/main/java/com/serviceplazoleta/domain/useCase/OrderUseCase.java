package com.serviceplazoleta.domain.useCase;

import com.serviceplazoleta.domain.api.IOrderServicePort;
import com.serviceplazoleta.domain.model.Order;
import com.serviceplazoleta.domain.spi.IOrderPersistencePort;
import com.serviceplazoleta.domain.spi.feignclient.IUserFeignClientPort;

public class OrderUseCase implements IOrderServicePort {

    private final IOrderPersistencePort orderPercistencePort;
    private final IUserFeignClientPort userFeignClientPort;



    public OrderUseCase(IOrderPersistencePort orderPercistencePort, IUserFeignClientPort userFeignClientPort) {
        this.orderPercistencePort = orderPercistencePort;
        this.userFeignClientPort = userFeignClientPort;
    }

    @Override
    public void saveOrder(Order order) {
        orderPercistencePort.saveOrder(order);

    }

    @Override
    public Boolean validateAccess(Long userId, String requiredRole, String token) {
        return userFeignClientPort.validateUserId(userId, requiredRole, token);
    }
}
