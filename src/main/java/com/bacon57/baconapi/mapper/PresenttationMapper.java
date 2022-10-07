package com.bacon57.baconapi.mapper;

import com.bacon57.baconapi.dto.PresentationDto;
import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.model.Presentation;
import com.bacon57.baconapi.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class PresenttationMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PresentationDto toDTO(Presentation presentation) {
        this.modelMapper = new ModelMapper();
        TypeMap<Product, ProductDto> propertyMapper = modelMapper.createTypeMap(Product.class, ProductDto.class);
//        propertyMapper.addMappings(modelMapper -> modelMapper.skip(ProductDto::setPresentations));
//        propertyMapper.addMappings(modelMapper -> modelMapper.map(src -> src.getCategory().getName(), ProductDto::setCategory));
        return Objects.isNull(presentation) ? null : modelMapper.map(presentation, PresentationDto.class);
    }
}
