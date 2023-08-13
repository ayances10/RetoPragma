package com.usuario.serviceusuario.application.mapper;

import com.usuario.serviceusuario.application.dto.RoleResponseDto;
import com.usuario.serviceusuario.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {

    RoleResponseDto toResponse(Role role);
}
