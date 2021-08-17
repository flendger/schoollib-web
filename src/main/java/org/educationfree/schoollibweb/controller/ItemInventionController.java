package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.operation.InventionServiceImpl;
import org.educationfree.schoollibweb.service.operation.OperationService;
import org.educationfree.schoollibweb.service.operation.item.InventionItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invention/item")
@RequiredArgsConstructor
public class ItemInventionController {
    private final InventionItemService inventionItemService;
    private final CatalogService<Book> bookService;

    @GetMapping("/{id}")
    public String addNewItem(Model model, @PathVariable Long id){
        model.addAttribute("item", inventionItemService.getNewItem(id));
        model.addAttribute("books", bookService.findAll());
        return "invention_item";
    }

    @PostMapping("/save")
    public String saveNewItem(@RequestBody InventionItem inventionItem, @PathVariable Long id){
        inventionItemService.save(inventionItem);
        return "redirect:/invention/item";
    }

    @GetMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, Model model){
        model.addAttribute("item", inventionItemService.findById(id));
        model.addAttribute("books", bookService.findAll());
        return "invention_item";
    }

    @GetMapping("/delete")
    public String deleteItem(@PathVariable Long id){
        inventionItemService.delete(id);
        return "redirect:/invention";
    }
}
