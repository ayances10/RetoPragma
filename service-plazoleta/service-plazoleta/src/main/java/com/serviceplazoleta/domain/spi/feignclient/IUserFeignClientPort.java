package com.serviceplazoleta.domain.spi.feignclient;

import com.serviceplazoleta.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IUserFeignClientPort {

    Boolean existUser(Long userId);

    User getUserById(Long userId);

    User getUserByMail(String mail);
    Boolean validateUserId(Long userId, String requiredRole, String token);
}
