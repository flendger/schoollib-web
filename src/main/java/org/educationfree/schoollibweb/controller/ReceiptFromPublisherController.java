package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.dto.PublisherDto;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.model.operation.ReceiptFromPublisher;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.operation.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receipt_fp")
@RequiredArgsConstructor
public class ReceiptFromPublisherController {
    private final OperationService<ReceiptFromPublisher> entityService;
    private final CatalogService<Location, LocationDto> locationService;
    private final CatalogService<Publisher, PublisherDto> publisherService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("invention", entityService.findAll());
        return "receipt_fp";
    }

    @GetMapping(value = "/{id}")
    public String show(Model model, @PathVariable Long id) {
        ReceiptFromPublisher entityDto = entityService.findByIdWithItems(id).orElseThrow();
        model.addAttribute("entity", entityDto);
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "receipt_fp_form";
    }

    @PostMapping
    public String save(ReceiptFromPublisher entityDto) {
        entityService.save(entityDto);
        return "redirect:/receipt_fp/" + entityDto.getId();
    }

    @GetMapping("/new")
    public String add(Model model) {
        ReceiptFromPublisher entityDto = new ReceiptFromPublisher();
        model.addAttribute("entity", entityDto);
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "receipt_fp_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String delete(@PathVariable Long id) {
        entityService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/receipt_fp";
    }
}
