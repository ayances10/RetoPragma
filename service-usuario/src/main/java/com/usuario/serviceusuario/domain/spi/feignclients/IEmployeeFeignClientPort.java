package com.usuario.serviceusuario.domain.spi.feignclients;

import com.usuario.serviceusuario.domain.model.Employee;

public interface IEmployeeFeignClientPort {

    void saveEmploye(Employee employee);
}
