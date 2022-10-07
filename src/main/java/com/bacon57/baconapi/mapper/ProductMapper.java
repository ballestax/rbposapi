package com.bacon57.baconapi.mapper;

import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDto toDTO(Product product) {
        this.modelMapper = new ModelMapper();
        TypeMap<Product, ProductDto> propertyMapper = modelMapper.createTypeMap(Product.class, ProductDto.class);
//        propertyMapper.addMappings(modelMapper -> modelMapper.skip(ProductDto::setPresentations));
        propertyMapper.addMappings(modelMapper -> modelMapper.map(src -> src.getCategory().getName(), ProductDto::setCategory));
        return Objects.isNull(product) ? null : modelMapper.map(product, ProductDto.class);
    }

}
