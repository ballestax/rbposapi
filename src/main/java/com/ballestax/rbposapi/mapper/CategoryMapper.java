package com.ballestax.rbposapi.mapper;

import com.ballestax.rbposapi.dto.CategoryDto;
import com.ballestax.rbposapi.dto.ProductDto;
import com.ballestax.rbposapi.model.Category;
import com.ballestax.rbposapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto entityToDto(Category entity);

    Category dtoToEntity(CategoryDto dto);
}
