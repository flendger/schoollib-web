package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final CatalogService<Location> locationService;

    @GetMapping
    public String showPersonList(Model model){
        System.out.println(locationService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return "location";
    }

    @GetMapping(value = "/{id}")
    public String showPersonForm(Model model, @PathVariable Long id){
        model.addAttribute("location", locationService.findById(id).orElseThrow());
        return "location_form";
    }
}