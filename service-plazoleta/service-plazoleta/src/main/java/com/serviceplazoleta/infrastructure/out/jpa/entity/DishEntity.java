package com.serviceplazoleta.infrastructure.out.jpa.entity;

import com.serviceplazoleta.domain.model.Category;
import com.serviceplazoleta.domain.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "platos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String description;
    private String urlImage;
    private Boolean active;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="restaurant_id")
    private RestaurantEntity restaurant;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="category_id")
    private CategoryEntity category;
}
