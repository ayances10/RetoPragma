package com.serviceplazoleta.infrastructure.out.feignclient;

import com.serviceplazoleta.infrastructure.out.feignclient.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-usuario", url = "localhost:8090/usuario")
public interface IUserFeignClient {

    @GetMapping("/existsUserById/{id}")
    Boolean existsUserById(@PathVariable(value = "id") Long userId);

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable(value = "id") Long userId);

    @GetMapping("/mail/{mail}")
    UserDto getUserByMail(@PathVariable(value = "mail") String mail);

    @PostMapping("/{id}/validateRole")
    ResponseEntity<Boolean> validateRole(@PathVariable(value = "id") Long userId, @RequestParam("requiredRole") String requiredRole, @RequestHeader("Authorization") String token);
}
