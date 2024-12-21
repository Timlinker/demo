package com.example.demo.controller;

import com.example.demo.model.Element;
import com.example.demo.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/elements")
public class ElementController {

    @Autowired
    private ElementService elementService;

    @GetMapping
    public Page<Element> getElements(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return elementService.getElements(page, size);
    }

    @GetMapping("/{id}")
    public Element getElement(@PathVariable Long id) {
        return elementService.getElementById(id)
                .orElseThrow(() -> new RuntimeException("Element not found!"));
    }

    @PostMapping
    public Element createElement(@RequestBody Element element) {
        element.setCreatedAt(element.getCreatedAt() == null ? LocalDate.now() : element.getCreatedAt());
        element.setPublished(element.getPublished() == null ? false : element.getPublished());
        return elementService.saveElement(element);
    }

    @PutMapping("/{id}")
    public Element updateElement(@PathVariable Long id, @RequestBody Element updatedElement) {
        Element existingElement = elementService.getElementById(id)
                .orElseThrow(() -> new RuntimeException("Element not found!"));
        existingElement.setTitle(updatedElement.getTitle());
        existingElement.setDescription(updatedElement.getDescription());
        existingElement.setContent(updatedElement.getContent());
        existingElement.setPublished(updatedElement.getPublished());
        return elementService.saveElement(existingElement);
    }

    @DeleteMapping("/{id}")
    public void deleteElement(@PathVariable Long id) {
        elementService.deleteElement(id);
    }
}
