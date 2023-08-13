package com.usuario.serviceusuario.domain.spi;

import com.usuario.serviceusuario.domain.model.Role;

public interface IRolePersistencePort {

    Role saveRole(Role role);
}
