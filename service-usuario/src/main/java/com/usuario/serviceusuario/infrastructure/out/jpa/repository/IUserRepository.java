package com.usuario.serviceusuario.infrastructure.out.jpa.repository;

import com.usuario.serviceusuario.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

        Optional<UserEntity> findByMail(String mail);
}
