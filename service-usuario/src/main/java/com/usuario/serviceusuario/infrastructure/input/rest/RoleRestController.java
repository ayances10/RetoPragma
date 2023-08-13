package com.usuario.serviceusuario.infrastructure.input.rest;

import com.usuario.serviceusuario.application.dto.RoleRequestDto;
import com.usuario.serviceusuario.application.handler.IRoleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RoleRestController {

    private final IRoleHandler roleHandler;

    @PostMapping("/role")
    public ResponseEntity<Void> saveRole(@Valid @RequestBody RoleRequestDto roleRequestDto){
        roleHandler.saveRole(roleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
