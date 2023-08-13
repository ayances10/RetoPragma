package com.serviceplazoleta.infrastructure.input.rest;

import com.serviceplazoleta.application.dto.RestaurantPaginationResponseDto;
import com.serviceplazoleta.application.dto.RestaurantRequestDto;
import com.serviceplazoleta.application.dto.RestaurantResponseDto;
import com.serviceplazoleta.application.handler.IRestaurantHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    public RestaurantRestController(IRestaurantHandler restaurantHandler) {
        this.restaurantHandler = restaurantHandler;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveRestaurant(@Valid @RequestBody RestaurantRequestDto restaurantRequestDto, HttpServletRequest request) throws Exception {
        Long propietarioId = getUserIdAndValidateAccess(request, "ADMIN");
        restaurantHandler.saveRestaurant(restaurantRequestDto, propietarioId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*
    * TU  -- Postman -- Endpoint -> | (Interceptor, hace algo) -> <- Aplicacion
    * */

    /*
    * 1. POST crear restaurante
    * 2. Plazoleta tiene un interceptor (SecurityFeignRequest) -> aqui extrae el token, y el userId del token
    * 3. Plazoleta usando el userId y el token, hace llamado a microservicio de usuarios usando el feign client.
    * 4. La request la recibe el microservicio de usuarios, y retorna si el usuario tiene el mismo rol.
    * 5. Plazoleta recibe la respuesta desde el microservicio de usuarios, si es verdadera, continua creando el restaurante, o sino, lanza un error.
    * */

    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantHandler.getAllRestaurants());
    }

    @GetMapping("/page/{page}/size/{size}")
    public ResponseEntity<List<RestaurantPaginationResponseDto>> getAllRestaurantPagination(@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        return ResponseEntity.ok(restaurantHandler.getRestaurantPaginationResponseDto(page,size));
    }

    private Long getUserIdAndValidateAccess(HttpServletRequest request, String requiredRole) throws Exception {
        Long userId = Long.valueOf((String) request.getAttribute("userId"));
        String token = request.getHeader("Authorization");
        restaurantHandler.validateAccess(userId, requiredRole, token);
        return userId;
    }
}
