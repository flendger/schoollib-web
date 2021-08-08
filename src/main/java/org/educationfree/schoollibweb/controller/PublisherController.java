package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {


    private final CatalogService<Publisher> publisherService;

    @GetMapping
    public String showPublisherList(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publisher";
    }

    @GetMapping(value = "/{id}")
    public String showPublishertForm(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherService.findById(id).orElseThrow());
        return "publisher-form";
    }

    @PostMapping("/update")
    public String updatePublisher(Model model, Publisher publisher, BindingResult bindingResult) {
        publisherService.save(publisher);

        return "redirect:/publisher";
    }

}
