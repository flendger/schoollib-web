package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book_type")
@RequiredArgsConstructor
public class BookTypeController {
    private final CatalogService<BookType> bookTypeService;

    @GetMapping
    public String showBookTypeList(Model model) {
        model.addAttribute("book_types", bookTypeService.findAll());
        return "book_type";
    }

    @GetMapping(value = "/{id}")
    public String showBookTypeForm(Model model, @PathVariable Long id) {
        model.addAttribute("book_type", bookTypeService.findById(id).orElseThrow());
        return "book_type_form";
    }

    @PostMapping
    public String updateBookType(BookType bookType) {
        bookTypeService.save(bookType);

        return "redirect:/book_type";
    }

    @GetMapping("/new")
    public String addBookType(Model model) {
        BookType bookType = new BookType();
        model.addAttribute("book_type", bookType);
        return "book_type_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteBookType(@PathVariable Long id) {
        bookTypeService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/book_type";
    }
}
