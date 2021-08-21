package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.LocationType;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location_type")
@RequiredArgsConstructor
public class LocationTypeController {

    private final CatalogService<LocationType> locationTypeService;

    @GetMapping
    public String showLocationTypeList(Model model) {
        model.addAttribute("locationTypes", locationTypeService.findAll());
        return "location_type";
    }

    @GetMapping(value = "/{id}")
    public String showLocationTypeForm(Model model, @PathVariable Long id) {

        model.addAttribute("locationType", locationTypeService.findById(id).orElseThrow());
        return "location_type_form";
    }

    @PostMapping
    public String updateLocationType(LocationType locationType) {
        locationTypeService.save(locationType);
        return "redirect:/location_type";
    }

    @GetMapping("/new")
    public String addLocationType(Model model) {
        LocationType locationType = new LocationType();
        model.addAttribute("locationType", locationType);
        return "location_type_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteLocationType(@PathVariable Long id) {
        locationTypeService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/location_type";
    }
}