package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.OrderRequestDto;
import com.serviceplazoleta.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderRequestMapper {

    Order toOrder(OrderRequestDto orderRequestDto);

}
