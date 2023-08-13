package com.usuario.serviceusuario.domain.useCase;

import com.usuario.serviceusuario.domain.api.IRoleServicePort;
import com.usuario.serviceusuario.domain.model.Role;
import com.usuario.serviceusuario.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort {


    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }


    @Override
    public void saveRole(Role role) {
        rolePersistencePort.saveRole(role);
    }
}
