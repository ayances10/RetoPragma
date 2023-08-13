package com.usuario.serviceusuario.domain.spi.feignclients;

import com.usuario.serviceusuario.domain.model.Restaurant;

public interface IRestaurantFeingClientPort {

    Restaurant getRestaurantByIdProprietor(Long idProprietor);
}
