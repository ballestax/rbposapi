package com.bacon57.baconapi.mapper;


import com.bacon57.baconapi.dto.PresentationDto;
import com.bacon57.baconapi.model.Presentation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PresentationMapper {

    PresentationMapper INSTANCE = Mappers.getMapper(PresentationMapper.class);

    PresentationDto presentationToPresentationDto(Presentation presentation);

    Presentation presentationDtoToPresentation(PresentationDto presentationDto);

    List<Presentation> presentationDtoListToPresentationList(List<PresentationDto> presentationDtoList);

    List<PresentationDto> presentationListToPresentationDtoList(List<Presentation> presentationList);
}
