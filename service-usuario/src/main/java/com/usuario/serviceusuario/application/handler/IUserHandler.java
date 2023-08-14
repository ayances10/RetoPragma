package com.usuario.serviceusuario.application.handler;

import com.usuario.serviceusuario.application.dto.UserRequestDto;
import com.usuario.serviceusuario.application.dto.UserResponseDto;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);

     UserResponseDto getUserById(Long id);

    UserResponseDto getUserByMail(String mail);
    Boolean validateUserHasRole(Long userId, String requiredRole) throws Exception;
}
