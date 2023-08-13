package com.serviceplazoleta.domain.useCase;

import com.serviceplazoleta.domain.api.ICategoryServicePort;
import com.serviceplazoleta.domain.model.Category;
import com.serviceplazoleta.domain.spi.ICategoryPersistencePort;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }
}
