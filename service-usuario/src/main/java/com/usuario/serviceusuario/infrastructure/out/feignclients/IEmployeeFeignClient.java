package com.usuario.serviceusuario.infrastructure.out.feignclients;

import com.usuario.serviceusuario.application.dto.EmployeeRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(contextId = "employee",name = "service-plazoleta",url = "localhost:8091/employe")
public interface IEmployeeFeignClient {

    @PostMapping("/")
    void saveEmployee(EmployeeRequestDto employeeRequestDto);
}
