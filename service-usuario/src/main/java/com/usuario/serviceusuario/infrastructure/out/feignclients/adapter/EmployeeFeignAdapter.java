package com.usuario.serviceusuario.infrastructure.out.feignclients.adapter;

import com.usuario.serviceusuario.application.dto.EmployeeRequestDto;
import com.usuario.serviceusuario.application.mapper.IEmployeeRequestMapper;
import com.usuario.serviceusuario.domain.model.Employee;
import com.usuario.serviceusuario.domain.spi.feignclients.IEmployeeFeignClientPort;
import com.usuario.serviceusuario.infrastructure.out.feignclients.IEmployeeFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeFeignAdapter implements IEmployeeFeignClientPort {
    private final IEmployeeFeignClient employeeFeignClient;
    private final IEmployeeRequestMapper employeeRequestMapper;
    @Override
    public void saveEmploye(Employee employee) {
        EmployeeRequestDto employeeRequestDto = employeeRequestMapper.toRequest(employee);
        employeeFeignClient.saveEmployee(employeeRequestDto);
    }
}
