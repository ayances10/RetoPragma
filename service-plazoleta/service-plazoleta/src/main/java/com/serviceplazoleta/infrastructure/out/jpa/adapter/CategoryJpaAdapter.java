package com.serviceplazoleta.infrastructure.out.jpa.adapter;

import com.serviceplazoleta.domain.model.Category;
import com.serviceplazoleta.domain.spi.ICategoryPersistencePort;
import com.serviceplazoleta.infrastructure.out.jpa.entity.CategoryEntity;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.repository.ICategoryRepository;

public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    public CategoryJpaAdapter(ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryEntityMapper.toEntity(category));
        return categoryEntityMapper.toCategory(categoryEntity);
    }
}
