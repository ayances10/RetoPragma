package com.serviceplazoleta.infrastructure.out.jpa.mapper;

import com.serviceplazoleta.domain.model.Dish;
import com.serviceplazoleta.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IDishEntityMapper {


    @Mapping(target = "restaurant.id", source = "restaurant.id")
    @Mapping(target = "category.id", source = "category.id")
    DishEntity toEntity(Dish dish);

    @Mapping(target = "restaurant.id", source = "restaurant.id")
    @Mapping(target = "category.id", source = "category.id")
    Dish toDish(DishEntity dishEntity);

    List<Dish> toDishList(List<DishEntity> dishEntityList);
}
