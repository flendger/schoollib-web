package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final CatalogService<Person> personService;

    @GetMapping
    public String showPersonList(Model model){
        model.addAttribute("persons", personService.findAll());
        return "person";
    }

    @GetMapping(value = "/{id}")
    public String showPersonForm(Model model, @PathVariable Long id){
        model.addAttribute("person", personService.findById(id).orElseThrow());
        return "person_form";
    }
}
