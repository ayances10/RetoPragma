package com.usuario.serviceusuario.infrastructure.out.feignclients;

import com.usuario.serviceusuario.application.dto.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "restaurant",name = "service-plazoleta", url = "localhost:8091/usuario")
public interface IRestaurantFeignClient {

    @GetMapping("/restaurantByIdPropietario/{id}")
    RestaurantResponseDto getRestaurantByIdProprietor(@PathVariable(value = "id") Long idPropietario);
}
