package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final CatalogService<Book> bookService;

    @GetMapping
    public String showPersonList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

    @GetMapping(value = "/{id}")
    public String showPersonForm(Model model, @PathVariable Long id){
        model.addAttribute("book", bookService.findById(id).orElseThrow());
        return "book_form";
    }
}