package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.dto.PresentationDto;
import com.bacon57.baconapi.exception.ResourceNotFoundException;
import com.bacon57.baconapi.mapper.PresentationMapper;
import com.bacon57.baconapi.mapper.ProductMapper;
import com.bacon57.baconapi.model.Presentation;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.repository.PresentationRepository;
import com.bacon57.baconapi.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    @Autowired
    private PresentationMapper mapper;

    @Override
    public Presentation savePresentation(Presentation presentation) {
        return presentationRepository.save(presentation);
    }

    @Override
    public List<PresentationDto> getAllPresentations() {
        return presentationRepository.findAll()
                .stream()
                .map(presentation -> mapper.presentationToPresentationDto(presentation))
                .collect(Collectors.toList());
    }

    @Override
    public List<Presentation> getAllPresentationsByProductId(Long productId) {
        return presentationRepository.findPresentationsByProductId(productId);
    }

    @Override
    public PresentationDto getPresentationById(long id) {
        return presentationRepository.findById(id).map(presentation -> mapper.presentationToPresentationDto(presentation)).orElseThrow(()->
                new ResourceNotFoundException("Presentation", "id", id));
    }

    @Override
    public Presentation updatePresentation(Presentation presentation, long id) {
        Presentation existingPresentation = presentationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Presentation", "id", id)
        );
        existingPresentation.setName(presentation.getName());
        existingPresentation.setPrice(presentation.getPrice());
        existingPresentation.set_default(presentation.is_default());
        existingPresentation.set_enabled(presentation.is_enabled());
        existingPresentation.setSerie(presentation.getSerie());

        presentationRepository.save(existingPresentation);
        return existingPresentation;

    }

    @Override
    public void delete(long id) {
        presentationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Presentation", "Id", id));
        presentationRepository.deleteById(id);
    }
}
