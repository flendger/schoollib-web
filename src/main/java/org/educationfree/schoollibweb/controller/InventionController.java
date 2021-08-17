package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.operation.InventionServiceImpl;
import org.educationfree.schoollibweb.service.operation.OperationService;
import org.educationfree.schoollibweb.service.operation.item.InventionItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invention")
@RequiredArgsConstructor
public class InventionController {
    private final InventionServiceImpl inventionService;
    private final InventionItemService inventionItemService;
    private final CatalogService<Location> locationService;

    @GetMapping
    public String showInventionList(Model model) {
        model.addAttribute("invention", inventionService.findAll());

        return "invention";
    }

    @GetMapping(value = "/{id}")
    public String showInvention(Model model, @PathVariable Long id) {
        Invention invention = inventionService.findById(id).orElseThrow();
        model.addAttribute("invention", invention);
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("items", inventionItemService.findAllByDocument(invention));
        return "invention_form";
    }

    @PostMapping
    public String updateOrSaveInvention(Invention invention) {
        inventionService.save(invention);
        return "redirect:/invention";
    }

    @GetMapping("/new")
    public String addInvention(Model model) {
        Invention invention = new Invention();
        model.addAttribute("invention", invention);
        model.addAttribute("locations", locationService.findAll());
        return "invention_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteInvention(@PathVariable Long id) {
        inventionService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/invention";
    }
}
