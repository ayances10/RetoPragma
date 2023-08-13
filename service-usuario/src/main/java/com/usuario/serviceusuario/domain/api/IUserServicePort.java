package com.usuario.serviceusuario.domain.api;

import com.usuario.serviceusuario.domain.model.User;
import com.usuario.serviceusuario.infrastructure.out.jpa.entity.UserEntity;

public interface IUserServicePort {

    void saveUser(User user);
    void savetEmployee(User user);

    User getUserById(Long id);

    User getUserByMail(String mail);

    Boolean validateUserHasRole(Long userId, String requiredRole) throws Exception;
}
