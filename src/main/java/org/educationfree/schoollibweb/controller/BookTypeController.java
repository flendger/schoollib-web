package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book_type")
@RequiredArgsConstructor
public class BookTypeController {
    private final CatalogService<BookType> bookTypeService;

    @GetMapping
    public String showPersonList(Model model){
        model.addAttribute("book_types", bookTypeService.findAll());
        return "book_type";
    }

    @GetMapping(value = "/{id}")
    public String showPersonForm(Model model, @PathVariable Long id){
        model.addAttribute("book_type", bookTypeService.findById(id).orElseThrow());
        return "book_type_form";
    }
}