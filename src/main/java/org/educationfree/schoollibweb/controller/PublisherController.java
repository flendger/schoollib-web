package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final CatalogService<Publisher> publisherService;

    @GetMapping
    public String showPersonList(Model model){
        model.addAttribute("publishers", publisherService.findAll());
        return "publisher";
    }

    @GetMapping(value = "/{id}")
    public String showPersonForm(Model model, @PathVariable Long id){
        model.addAttribute("publisher", publisherService.findById(id).orElseThrow());
        return "publisher_form";
    }
}