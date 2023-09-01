package com.ballestax.rbposapi.mapper;

import com.ballestax.rbposapi.dto.AdditionalDto;
import com.ballestax.rbposapi.model.Additional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdditionalMapper {

    AdditionalMapper INSTANCE = Mappers.getMapper(AdditionalMapper.class);

    AdditionalDto additionalToAdditionalDto(Additional additional);

    Additional additionalDtoToAdditional(AdditionalDto additionalDto);

    List<Additional> additionalDtoListToAdditionalList(List<AdditionalDto> additionalDtoList);

    List<AdditionalDto> additionalListToAdditionalDtoList(List<Additional> additionalList);
}
