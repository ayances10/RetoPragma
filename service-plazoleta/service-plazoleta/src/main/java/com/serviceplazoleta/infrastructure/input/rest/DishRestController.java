package com.serviceplazoleta.infrastructure.input.rest;

import com.serviceplazoleta.application.dto.DishRequestDto;
import com.serviceplazoleta.application.dto.DishUpdateRequestDto;
import com.serviceplazoleta.application.handler.IDishHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("dish")
public class DishRestController {

    private final IDishHandler dishHandler;

    public DishRestController(IDishHandler dishHandler) {
        this.dishHandler = dishHandler;
    }
    @PostMapping("/save")
    public ResponseEntity<Void> saveDish(@Valid @RequestBody DishRequestDto dishRequestDto, HttpServletRequest request) throws Exception{
        Long propietarioId = getUserIdAndValidateAccess(request,"PROPIETARIO");
        dishHandler.saveDish(dishRequestDto, propietarioId,request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DishRequestDto> updateDish(@PathVariable(value = "id")Long dishId,
                                                     @RequestBody DishUpdateRequestDto dishUpdateRequestDto,
                                                     Long restaurantId, HttpServletRequest request,Long propietarioId) throws Exception{
        propietarioId = getUserIdAndValidateAccess(request,"PROPIETARIO");
        dishHandler.updateDish(dishId,dishUpdateRequestDto,restaurantId,request, propietarioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Long getUserIdAndValidateAccess(HttpServletRequest request, String requiredRole) throws Exception {
        Long userId = Long.valueOf((String) request.getAttribute("userId"));
        String token = request.getHeader("Authorization");
        dishHandler.validateAccess(userId, requiredRole, token);
        return userId;
    }
}
