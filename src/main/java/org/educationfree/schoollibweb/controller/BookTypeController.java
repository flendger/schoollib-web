package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booktype")
@RequiredArgsConstructor
public class BookTypeController {


    private final CatalogService<BookType> bookTypeService;

    @GetMapping
    public String showBookTypeList(Model model) {
        model.addAttribute("booktypes", bookTypeService.findAll());
        return "booktype";
    }

    @GetMapping(value = "/{id}")
    public String showBookTypeForm(Model model, @PathVariable Long id) {
        model.addAttribute("booktype", bookTypeService.findById(id).orElseThrow());
        return "booktype-form";
    }

    @PostMapping("/update")
    public String updateBookType(Model model, BookType bookType, BindingResult bindingResult) {
        bookTypeService.save(bookType);

        return "redirect:/booktype";
    }

}
