package com.example.demo.service;

import com.example.demo.model.Element;
import com.example.demo.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;

    public Page<Element> getElements(int page, int size) {
        return elementRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Element> getElementById(Long id) {
        return elementRepository.findById(id);
    }

    public Element saveElement(Element element) {
        return elementRepository.save(element);
    }

    public void deleteElement(Long id) {
        elementRepository.deleteById(id);
    }
}
