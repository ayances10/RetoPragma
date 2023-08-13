package com.usuario.serviceusuario.application.mapper;

import com.usuario.serviceusuario.application.dto.EmployeeRequestDto;
import com.usuario.serviceusuario.domain.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEmployeeRequestMapper {

    Employee toEmployee(EmployeeRequestDto employeeRequestDto);

    EmployeeRequestDto toRequest(Employee employee);
}
