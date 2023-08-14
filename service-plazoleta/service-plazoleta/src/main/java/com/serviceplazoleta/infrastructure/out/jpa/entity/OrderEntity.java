package com.serviceplazoleta.infrastructure.out.jpa.entity;

import com.serviceplazoleta.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idClient;
    private Date date;
    private String state;

    /*
    @ManyToOne
    @JoinColumn(name = "chef_id")
    private User user;
    */

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;


}
