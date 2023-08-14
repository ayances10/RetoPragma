package com.usuario.serviceusuario.domain.useCase;


import com.usuario.serviceusuario.domain.spi.IUserPersistencePort;
import com.usuario.serviceusuario.domain.spi.feignclients.IRestaurantFeingClientPort;
import com.usuario.serviceusuario.domain.spi.token.IToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;

    @Mock
    IUserPersistencePort userPersistencePort;

    @Mock
    IToken token;
    @Mock
    IRestaurantFeingClientPort restaurantFeingClientPort;

    @Mock
    IEmployeeFeignClientPort employeeFeignClientPort;


    @Test
    void saveOwner(){

    }

}
