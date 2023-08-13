package com.usuario.serviceusuario.domain.spi.token;

public interface IToken {

    String getBearerToken();
    String getMail(String token);
    Long getUserAuthenticatedId(String token);

    String getUserAuthenticatedRole(String token);
}
