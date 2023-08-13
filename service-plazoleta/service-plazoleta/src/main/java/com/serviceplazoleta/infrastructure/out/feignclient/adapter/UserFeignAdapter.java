package com.serviceplazoleta.infrastructure.out.feignclient.adapter;

import com.serviceplazoleta.domain.model.User;
import com.serviceplazoleta.domain.spi.feignclient.IUserFeignClientPort;
import com.serviceplazoleta.infrastructure.out.feignclient.IUserFeignClient;
import com.serviceplazoleta.infrastructure.out.feignclient.dto.UserDto;
import com.serviceplazoleta.infrastructure.out.feignclient.mapper.IUserDtoMapper;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class UserFeignAdapter implements IUserFeignClientPort {

    private final IUserFeignClient userFeignClient;
    private final IUserDtoMapper userDtoMapper;

    public UserFeignAdapter(IUserFeignClient userFeignClient, IUserDtoMapper userDtoMapper) {
        this.userFeignClient = userFeignClient;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public Boolean existUser(Long userId) {
        return userFeignClient.existsUserById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        UserDto userDto = userFeignClient.getUserById(userId);
        return userDtoMapper.toUser(userDto);
    }

    @Override
    public User getUserByMail(String mail) {
        UserDto userDto = userFeignClient.getUserByMail(mail);
        return userDtoMapper.toUser(userDto);
    }

    @Override
    public Boolean validateUserId(Long userId, String requiredRole, String token) {
        ResponseEntity<Boolean> responseEntity = userFeignClient.validateRole(userId, requiredRole, token);
        return responseEntity.getBody();
    }


}
