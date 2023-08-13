package com.usuario.serviceusuario.infrastructure.input.rest;


import com.usuario.serviceusuario.application.dto.UserRequestDto;
import com.usuario.serviceusuario.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/propietario")
    public ResponseEntity<Void> savePropietario(@RequestBody UserRequestDto request) {
        userHandler.saveUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/validateRole")
    public ResponseEntity<Boolean> validateRole(@Valid @PathVariable("id") Long userId, @RequestParam("requiredRole") String requiredRole) throws Exception {
        Boolean userHasRole = userHandler.validateUserHasRole(userId, requiredRole);
        return new ResponseEntity<>(userHasRole, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Void> saveEmployee(@RequestBody UserRequestDto empleado){
        userHandler.saveUser(empleado);
        userHandler.saveEmployee(empleado);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/client")
    public ResponseEntity<Void> saveClient(@Valid @RequestBody UserRequestDto client){
        userHandler.saveUser(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
