package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.DishRequestDto;
import com.serviceplazoleta.application.dto.DishResponseDto;
import com.serviceplazoleta.application.dto.DishUpdateRequestDto;
import com.serviceplazoleta.application.mapper.IDishRequestMapper;
import com.serviceplazoleta.application.mapper.IDishResponseMapper;
import com.serviceplazoleta.domain.api.IDishServicePort;
import com.serviceplazoleta.domain.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DishHandler implements IDishHandler{
    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    private final IDishResponseMapper dishResponseMapper;
    @Override
    public void saveDish(DishRequestDto dishRequestDto, Long restaurantId,HttpServletRequest request) {
        Dish dish = dishRequestMapper.toDish(dishRequestDto);
        dishServicePort.saveDish(dish,restaurantId,request);
    }

    @Override
    public DishResponseDto getDishById(Long id, DishUpdateRequestDto dishUpdateRequestDto) {
        Dish dish = dishServicePort.getDishById(id);
        return dishResponseMapper.toResponse(dish);
    }

    @Override
    public void updateDish(Long id, DishUpdateRequestDto dishUpdateRequestDto, Long restaurantId, HttpServletRequest request, Long propietarioId) {
        Dish dish = dishRequestMapper.toDishUpdate(dishUpdateRequestDto);
        dishServicePort.updateDish(id,dish,restaurantId,request,propietarioId);
    }


    @Override
    public void validateAccess(Long userId, String requiredRole, String token) throws Exception {
        Boolean hasValidAcces = dishServicePort.validateAccess(userId,requiredRole,token);
        if (!hasValidAcces){
            throw new Exception("User has no access to this resource.");
        }
    }
}
