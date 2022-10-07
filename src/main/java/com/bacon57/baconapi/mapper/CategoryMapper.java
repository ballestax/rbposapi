package com.bacon57.baconapi.mapper;

import com.bacon57.baconapi.dto.CategoryDto;
import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.model.Category;
import com.bacon57.baconapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto entityToDto(Category entity);

    Category dtoToEntity(CategoryDto dto);
}
