package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final CatalogService<Owner> ownerService;

    @GetMapping
    public String showPersonList(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owner";
    }

    @GetMapping(value = "/{id}")
    public String showPersonForm(Model model, @PathVariable Long id){
        model.addAttribute("owner", ownerService.findById(id).orElseThrow());
        return "owner_form";
    }
}