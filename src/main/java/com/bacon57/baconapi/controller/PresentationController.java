package com.bacon57.baconapi.controller;

import com.bacon57.baconapi.dto.CategoryDto;
import com.bacon57.baconapi.dto.PresentationDto;
import com.bacon57.baconapi.model.Category;
import com.bacon57.baconapi.model.Presentation;
import com.bacon57.baconapi.service.CategoryService;
import com.bacon57.baconapi.service.PresentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        return new ResponseEntity<Presentation>(presentationService.savePresentation(presentation), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PresentationDto> getAllPresentations() {
        return presentationService.getAllPresentations();
    }

    @GetMapping("{id}")
    public ResponseEntity<Presentation> getPresentationById(@PathVariable("id") long presentationId) {
        return new ResponseEntity<Presentation>(presentationService.getPresentationById(presentationId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Presentation> updatePresentation(@PathVariable("id") long id, @RequestBody Presentation presentation) {
        return new ResponseEntity<Presentation>(presentationService.updatePresentation(presentation, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePresentation(@PathVariable("id") long id) {
        presentationService.delete(id);
        return new ResponseEntity<String>("Presentation deleted successfully!", HttpStatus.OK);
    }


}
