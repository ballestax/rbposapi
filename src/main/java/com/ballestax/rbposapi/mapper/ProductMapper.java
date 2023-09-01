package com.ballestax.rbposapi.mapper;

import com.ballestax.rbposapi.dto.ProductDto;
import com.ballestax.rbposapi.dto.ProductFullDto;
import com.ballestax.rbposapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.name", target = "category")
    ProductDto entityToDto(Product entity);
    List<ProductDto> entityListToToDtoList(List<Product> entityList);


    @Mapping(target = "category", ignore = true)
    Product dtoToEntity(ProductDto dto);

    List<Product> dtoListToEntityList(List<ProductDto> dtoList);

    @Mapping(source = "category.name", target = "category")
    ProductFullDto productToProductFullDto(Product product);

    @Mapping(target = "category", ignore = true)
    Product productFullDtoToProduct(ProductFullDto productFullDto);


}
