package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final CatalogService<Owner> ownerService;

    @GetMapping
    public String showOwnerList(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner";
    }

    @GetMapping(value = "/{id}")
    public String showOwnerForm(Model model, @PathVariable Long id) {
        model.addAttribute("owner", ownerService.findById(id).orElseThrow());
        return "owner_form";
    }

    @PostMapping
    public String updateOwner(Owner owner) {
        ownerService.save(owner);
        return "redirect:/owner";
    }

    @GetMapping("/new")
    public String addOwner(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "owner_form";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.setDeleted(id);
        return "redirect:/owner";
    }
}
