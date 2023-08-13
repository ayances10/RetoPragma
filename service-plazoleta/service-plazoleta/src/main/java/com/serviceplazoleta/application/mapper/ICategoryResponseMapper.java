package com.serviceplazoleta.application.mapper;

import com.serviceplazoleta.application.dto.CategoryResponseDto;
import com.serviceplazoleta.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryResponseMapper {

    CategoryResponseDto toResponse(Category category);
}
