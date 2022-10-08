package com.bacon57.baconapi.mapper;

import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.dto.ProductFullDto;
import com.bacon57.baconapi.model.Product;
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
