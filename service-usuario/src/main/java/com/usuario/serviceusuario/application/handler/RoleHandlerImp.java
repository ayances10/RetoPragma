package com.usuario.serviceusuario.application.handler;

import com.usuario.serviceusuario.application.dto.RoleRequestDto;
import com.usuario.serviceusuario.application.mapper.IRoleRequestMapper;
import com.usuario.serviceusuario.domain.api.IRoleServicePort;
import com.usuario.serviceusuario.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandlerImp implements IRoleHandler{

    private final IRoleServicePort roleServicePort;
    private final IRoleRequestMapper roleRequestMapper;
    @Override
    public void saveRole(RoleRequestDto roleRequestDto) {
        Role role = roleRequestMapper.toRole((roleRequestDto));
        roleServicePort.saveRole(role);
    }
}
