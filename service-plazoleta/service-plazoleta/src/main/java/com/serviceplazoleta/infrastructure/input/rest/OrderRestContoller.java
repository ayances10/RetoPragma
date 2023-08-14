package com.serviceplazoleta.infrastructure.input.rest;

import com.serviceplazoleta.application.dto.OrderRequestDto;
import com.serviceplazoleta.application.dto.OrderResponseDto;
import com.serviceplazoleta.application.handler.IOrderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestContoller {

    private final IOrderHandler orderHandler;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto,  HttpServletRequest request) throws Exception{
        Long propietarioId = getUserIdAndValidateAccess(request, "CLIENTE");
        orderHandler.saveOrder(orderRequestDto,propietarioId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    private Long getUserIdAndValidateAccess(HttpServletRequest request, String requiredRole) throws Exception {
        Long userId = Long.valueOf((String) request.getAttribute("userId"));
        String token = request.getHeader("Authorization");
        orderHandler.validateAccess(userId, requiredRole, token);
        return userId;
    }
}
