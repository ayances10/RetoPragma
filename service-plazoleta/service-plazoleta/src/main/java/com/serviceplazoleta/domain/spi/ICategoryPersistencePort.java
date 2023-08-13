package com.serviceplazoleta.domain.spi;

import com.serviceplazoleta.domain.model.Category;

public interface ICategoryPersistencePort {

    Category saveCategory(Category category);
}
