package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.PublisherDto;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final CatalogService<Publisher, PublisherDto> publisherService;

    @GetMapping
    public String showPublisherList(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publisher";
    }

    @GetMapping(value = "/{id}")
    public String showPublishertForm(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherService.findById(id).orElseThrow());
        return "publisher_form";
    }

    @PostMapping
    public String updatePublisher(PublisherDto publisher) {
        publisherService.save(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/new")
    public String addPublisher(Model model) {
        PublisherDto publisher = new PublisherDto();
        model.addAttribute("publisher", publisher);
        return "publisher_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deletePublisher(@PathVariable Long id) {
        publisherService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/publisher";
    }
}
