package com.usuario.serviceusuario.application.handler;

import com.usuario.serviceusuario.application.dto.UserRequestDto;
import com.usuario.serviceusuario.application.dto.UserResponseDto;
import com.usuario.serviceusuario.application.mapper.IUserRequestMapper;
import com.usuario.serviceusuario.application.mapper.IUserResponseMapper;
import com.usuario.serviceusuario.domain.api.IUserServicePort;
import com.usuario.serviceusuario.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandlerImp implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;
    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        User user = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(user);
    }

    @Override
    public void saveEmployee(UserRequestDto userRequestDto) {
        User user = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveEmployee(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        UserResponseDto userResponseDto = userResponseMapper.toResponse(userServicePort.getUserById(id));
        return userResponseDto;
    }

    @Override
    public UserResponseDto getUserByMail(String mail) {
        UserResponseDto userResponseDto = userResponseMapper.toResponse(userServicePort.getUserByMail(mail));
        return userResponseDto;
    }


    @Override
    public Boolean validateUserHasRole(Long userId, String requiredRole) throws Exception {
        return userServicePort.validateUserHasRole(userId, requiredRole);
    }
}
