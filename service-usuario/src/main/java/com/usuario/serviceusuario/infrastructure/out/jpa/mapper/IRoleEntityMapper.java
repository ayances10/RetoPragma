package com.usuario.serviceusuario.infrastructure.out.jpa.mapper;

import com.usuario.serviceusuario.domain.model.Role;
import com.usuario.serviceusuario.infrastructure.out.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {

    RoleEntity toEntity(Role role);

    Role toRoleModel(RoleEntity roleEntity);
}
