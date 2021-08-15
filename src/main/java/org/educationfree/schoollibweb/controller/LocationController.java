package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Location;
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
    private final CatalogService<Location> locationService;

    @GetMapping
    public String showLocationList(Model model){
        System.out.println(locationService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return "location";
    }

    @GetMapping(value = "/{id}")
    public String showLocationForm(Model model, @PathVariable Long id){
        model.addAttribute("location", locationService.findById(id).orElseThrow());
        return "location_form";
    }

    @PostMapping
    public String updateLocation(Location location) {
        locationService.save(location);
        return "redirect:/location";
    }

    @GetMapping("/new")
    public String addLocation( Model model ) {
        Location location = new Location();
        model.addAttribute("location",location);
        return "location_form";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.setDeleted(id, true);
        return "redirect:/location";
    }
}