package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.DishRequestDto;
import com.serviceplazoleta.application.dto.DishResponseDto;
import com.serviceplazoleta.application.dto.DishUpdateRequestDto;

import javax.servlet.http.HttpServletRequest;

public interface IDishHandler {

    void saveDish(DishRequestDto dishRequestDto, Long restaurantId,HttpServletRequest request);

    DishResponseDto getDishById(Long id,DishUpdateRequestDto dishUpdateRequestDto);
    void updateDish(Long id, DishUpdateRequestDto dishUpdateRequestDto, Long restaurantId, HttpServletRequest request, Long propietarioId);

    void validateAccess(Long userId, String requiredRole,String token) throws Exception;
}
