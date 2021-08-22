package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.operation.OperationService;
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
    private final OperationService<Invention> entityService;
    private final CatalogService<Location, LocationDto> locationService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("entities", entityService.findAll());

        return "invention";
    }

    @GetMapping(value = "/{id}")
    public String show(Model model, @PathVariable Long id) {
        Invention entityDto = entityService.findByIdWithItems(id).orElseThrow();
        model.addAttribute("entity", entityDto);
        model.addAttribute("locations", locationService.findAll());
        return "invention_form";
    }

    @PostMapping
    public String save(Invention entityDto) {
        entityService.save(entityDto);
        return "redirect:/invention/" + entityDto.getId();
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("entity", new Invention());
        model.addAttribute("locations", locationService.findAll());
        return "invention_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String delete(@PathVariable Long id) {
        entityService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/invention";
    }
}
