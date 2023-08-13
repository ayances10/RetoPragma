package com.usuario.serviceusuario.application.mapper;


import com.usuario.serviceusuario.application.dto.UserResponseDto;
import com.usuario.serviceusuario.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    UserResponseDto toResponse(User user);
}
