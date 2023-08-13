package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.CategoryRequestDto;
import com.serviceplazoleta.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryRequestMapper {

    Category toCategory(CategoryRequestDto categoryRequestDto);
}
