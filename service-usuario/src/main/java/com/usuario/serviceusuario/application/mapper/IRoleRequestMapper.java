package com.usuario.serviceusuario.application.mapper;


import com.usuario.serviceusuario.application.dto.RoleRequestDto;
import com.usuario.serviceusuario.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleRequestMapper {

    Role toRole(RoleRequestDto roleRequestDto);
}
