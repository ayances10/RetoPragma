package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.OrderResponseDto;
import com.serviceplazoleta.domain.model.Order;

import java.util.List;

public interface IOrderResponseMapper {

    OrderResponseDto toResponse(Order order);

    List<OrderResponseDto> toResponseList(List<Order> orderList);
}
