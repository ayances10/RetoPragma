package com.serviceplazoleta.domain.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    private Long id;
    private Long idClient;
    private Date date;
    private String state;
    private User IdUser;
    private Restaurant restaurant;
}
