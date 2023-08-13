package com.usuario.serviceusuario.domain.spi;

import com.usuario.serviceusuario.domain.model.User;
import com.usuario.serviceusuario.infrastructure.out.jpa.entity.UserEntity;

import java.util.Optional;

public interface IUserPersistencePort {

    Optional<UserEntity> findUserById(Long id);

    User saveUser(User user);
    User getUserById(Long id);
    User getUserByMail(String mail);
}
