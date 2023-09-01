package com.ballestax.rbposapi.service.impl;

import com.ballestax.rbposapi.dto.PresentationDto;
import com.ballestax.rbposapi.exception.ResourceNotFoundException;
import com.ballestax.rbposapi.mapper.PresentationMapper;
import com.ballestax.rbposapi.mapper.ProductMapper;
import com.ballestax.rbposapi.model.Presentation;
import com.ballestax.rbposapi.model.Product;
import com.ballestax.rbposapi.repository.PresentationRepository;
import com.ballestax.rbposapi.service.PresentationService;
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
