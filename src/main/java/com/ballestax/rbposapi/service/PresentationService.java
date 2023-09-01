package com.ballestax.rbposapi.service;

import com.ballestax.rbposapi.dto.PresentationDto;
import com.ballestax.rbposapi.model.Presentation;

import java.util.List;

public interface PresentationService {

    Presentation savePresentation(Presentation presentation);

    List<PresentationDto> getAllPresentations();

    List<Presentation> getAllPresentationsByProductId(Long productId);

    PresentationDto getPresentationById(long id);

    Presentation updatePresentation(Presentation presentation, long id);

    void delete(long id);

}
