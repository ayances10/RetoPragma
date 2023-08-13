package com.usuario.serviceusuario.application.mapper;

import com.usuario.serviceusuario.application.dto.EmployeeResponseDto;
import com.usuario.serviceusuario.domain.model.Employee;

import java.util.List;

public interface IEmployeeResponseMapper {

    EmployeeResponseDto toResponse(Employee employee);

    List<EmployeeResponseDto> toResponseList(List<Employee> employeeList);
}
