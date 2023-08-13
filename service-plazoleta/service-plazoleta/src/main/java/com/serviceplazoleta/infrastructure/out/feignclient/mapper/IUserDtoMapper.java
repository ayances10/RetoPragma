package com.serviceplazoleta.infrastructure.out.feignclient.mapper;

import com.serviceplazoleta.domain.model.User;
import com.serviceplazoleta.infrastructure.out.feignclient.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserDtoMapper {

    User toUser(UserDto userDto);
}
