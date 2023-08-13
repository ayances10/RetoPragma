package com.usuario.serviceusuario.infrastructure.out.jpa.adapter;

import com.usuario.serviceusuario.domain.model.Role;
import com.usuario.serviceusuario.domain.spi.IRolePersistencePort;
import com.usuario.serviceusuario.infrastructure.out.jpa.entity.RoleEntity;
import com.usuario.serviceusuario.infrastructure.out.jpa.mapper.IRoleEntityMapper;
import com.usuario.serviceusuario.infrastructure.out.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;


    @Override
    public Role saveRole(Role role) {
        RoleEntity roleEntity = roleRepository.save(roleEntityMapper.toEntity(role));
        return roleEntityMapper.toRoleModel(roleEntity);
    }
}
