package com.serviceplazoleta.infrastructure.out.jpa.entity;


import com.serviceplazoleta.domain.model.Dish;
import com.serviceplazoleta.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pepidos_platos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "plato_id", nullable = false)
    private DishEntity dish;

    private String quantity;
}
