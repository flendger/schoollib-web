package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.Invention;
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
    private final OperationService<Invention> inventionService;

    @GetMapping
    public String showBookTypeList(Model model) {
        model.addAttribute("invention", inventionService.findAll());
        return "invention";
    }

    @GetMapping(value = "/{id}")
    public String showBookTypeForm(Model model, @PathVariable Long id) {
        model.addAttribute("invention", inventionService.findById(id).orElseThrow());
        return "invention_form";
    }

    @PostMapping
    public String updateBookType(Invention invention) {
        inventionService.save(invention);

        return "redirect:/invention";
    }

    @GetMapping("/new")
    public String addBookType(Model model) {
        Invention invention = new Invention();
        model.addAttribute("invention", invention);
        return "invention_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteBookType(@PathVariable Long id) {
        inventionService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/invention";
    }
}
