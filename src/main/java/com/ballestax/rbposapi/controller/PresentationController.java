package com.ballestax.rbposapi.controller;

import com.ballestax.rbposapi.dto.PresentationDto;
import com.ballestax.rbposapi.model.Presentation;
import com.ballestax.rbposapi.service.PresentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/presentations")
public class PresentationController {

    private PresentationService presentationService;

    public PresentationController(PresentationService categoryService) {
        this.presentationService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Presentation> savePresentation(@RequestBody Presentation presentation) {
        return new ResponseEntity<>(presentationService.savePresentation(presentation), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PresentationDto> getAllPresentations() {
        return presentationService.getAllPresentations();
    }

    @GetMapping("{id}")
    public ResponseEntity<PresentationDto> getPresentationById(@PathVariable("id") long presentationId) {
        return new ResponseEntity<>(presentationService.getPresentationById(presentationId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Presentation> updatePresentation(@PathVariable("id") long id, @RequestBody Presentation presentation) {
        return new ResponseEntity<>(presentationService.updatePresentation(presentation, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePresentation(@PathVariable("id") long id) {
        presentationService.delete(id);
        return new ResponseEntity<>("Presentation deleted successfully!", HttpStatus.OK);
    }


}
