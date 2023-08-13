package com.serviceplazoleta.application.handler;

import com.serviceplazoleta.application.dto.CategoryRequestDto;
import com.serviceplazoleta.application.mapper.ICategoryRequestMapper;
import com.serviceplazoleta.application.mapper.ICategoryResponseMapper;
import com.serviceplazoleta.domain.api.ICategoryServicePort;
import com.serviceplazoleta.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;

    @Override
    public void saveCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryRequestMapper.toCategory(categoryRequestDto);
        categoryServicePort.saveCategory(category);
    }
}
