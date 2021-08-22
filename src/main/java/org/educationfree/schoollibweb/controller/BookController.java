package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.BookTypeDto;
import org.educationfree.schoollibweb.dto.OwnerDto;
import org.educationfree.schoollibweb.dto.PublisherDto;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final CatalogService<Book, BookDto> bookService;
    private final CatalogService<BookType, BookTypeDto> bookTypeService;
    private final CatalogService<Publisher, PublisherDto> publisherService;
    private final CatalogService<Owner, OwnerDto> ownerService;

    @GetMapping
    public String showBookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

    @GetMapping(value = "/{id}")
    public String showBookForm(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findById(id).orElseThrow());
        model.addAttribute("bookTypes", bookTypeService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("owners", ownerService.findAll());
        return "book_form";
    }

    @PostMapping
    public String updateBook(BookDto book) {
        bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/new")
    public String addBook(Model model) {
        BookDto book = new BookDto();
        model.addAttribute("book", book);
        model.addAttribute("bookTypes", bookTypeService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("owners", ownerService.findAll());
        return "book_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteBook(@PathVariable Long id) {
        bookService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/book";
    }
}