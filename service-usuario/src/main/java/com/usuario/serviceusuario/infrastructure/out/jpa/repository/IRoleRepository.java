package com.usuario.serviceusuario.infrastructure.out.jpa.repository;

import com.usuario.serviceusuario.infrastructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
