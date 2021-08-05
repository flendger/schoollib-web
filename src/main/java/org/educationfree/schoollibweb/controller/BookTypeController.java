package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//    @PostMapping(value = "/save/{id}")
//    public String saveBookTypeForm(Model model, @PathVariable Long id) {
//
//        model.addAttribute("booktype", bookTypeService.save();
//        return "booktype-form";
//    }
@DeleteMapping("/{id}/delete")
public String deleteBookType(@PathVariable("id") Long id,Model model) {
    bookTypeService.deleteById(id);

    return "redirect:/booktype";
}
}
