package com.usuario.serviceusuario.application.handler;

import com.usuario.serviceusuario.application.dto.UserRequestDto;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);

    void saveEmployee(UserRequestDto userRequestDto);
    Boolean validateUserHasRole(Long userId, String requiredRole) throws Exception;
}
