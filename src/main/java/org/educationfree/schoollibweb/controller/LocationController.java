package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.dto.LocationTypeDto;
import org.educationfree.schoollibweb.dto.PersonDto;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.catalog.LocationType;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final CatalogService<Location, LocationDto> locationService;
    private final CatalogService<LocationType, LocationTypeDto> locationTypeService;
    private final CatalogService<Person, PersonDto> personService;

    @GetMapping
    public String showLocationList(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "location";
    }

    @GetMapping(value = "/{id}")
    public String showLocationForm(Model model, @PathVariable Long id) {
        model.addAttribute("location", locationService.findById(id).orElseThrow());
        model.addAttribute("types", locationTypeService.findAll());
        model.addAttribute("persons", personService.findAll());
        return "location_form";
    }

    @PostMapping
    public String updateLocation(LocationDto location) {
        locationService.save(location);
        return "redirect:/location";
    }

    @GetMapping("/new")
    public String addLocation(Model model) {
        LocationDto location = new LocationDto();
        model.addAttribute("location", location);
        model.addAttribute("types", locationTypeService.findAll());
        model.addAttribute("persons", personService.findAll());
        return "location_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteLocation(@PathVariable Long id) {
        locationService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/location";
    }
}