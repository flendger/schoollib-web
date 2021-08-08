package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return "owner-form";
    }

    @PostMapping("/update")
    public String updateOwner(Model model, Owner owner, BindingResult bindingResult) {
        ownerService.save(owner);

        return "redirect:/owner";
    }

}
