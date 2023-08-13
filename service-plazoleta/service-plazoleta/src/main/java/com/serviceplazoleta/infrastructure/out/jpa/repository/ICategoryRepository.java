package com.serviceplazoleta.infrastructure.out.jpa.repository;

import com.serviceplazoleta.infrastructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
