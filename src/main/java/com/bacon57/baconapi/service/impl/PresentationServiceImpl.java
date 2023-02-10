package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.dto.PresentationDto;
import com.bacon57.baconapi.model.Presentation;
import com.bacon57.baconapi.repository.PresentationRepository;
import com.bacon57.baconapi.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    @Override
    public Presentation savePresentation(Presentation presentation) {
        return null;
    }

    @Override
    public List<PresentationDto> getAllPresentations() {
        return null;
    }

    @Override
    public List<Presentation> getAllPresentationsByProductId(Long productId) {
        return presentationRepository.findPresentationsByProductId(productId);
    }

    @Override
    public Presentation getPresentationById(long id) {
        return null;
    }

    @Override
    public Presentation updatePresentation(Presentation presentation, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
