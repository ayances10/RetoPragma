package com.usuario.serviceusuario.infrastructure.out.jpa.adapter;

import com.usuario.serviceusuario.domain.model.User;
import com.usuario.serviceusuario.domain.spi.IUserPersistencePort;
import com.usuario.serviceusuario.infrastructure.out.jpa.entity.UserEntity;
import com.usuario.serviceusuario.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.usuario.serviceusuario.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toUserMolde(userEntity);
    }
}
