package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.operation.item.OperationItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invention/item")
@RequiredArgsConstructor
public class ItemInventionController {
    private final OperationItemService<InventionItem> inventionItemService;
    private final CatalogService<Book, BookDto> bookService;

    @GetMapping("/{id}")
    public String updateItem(@PathVariable Long id, Model model){
        model.addAttribute("item", inventionItemService.findById(id).orElseThrow());
        model.addAttribute("books", bookService.findAll());
        return "invention_item";
    }

    @PostMapping("/save")
    public String saveNewItem(InventionItem inventionItem){
        inventionItemService.save(inventionItem);
        return "redirect:/invention/" + inventionItem.getDocument().getId();
    }

    @GetMapping("/new")
    public String addInventionItem(Model model, @RequestParam("document_id") Long documentId){
        model.addAttribute("item", inventionItemService.newInstance(documentId));
        model.addAttribute("books", bookService.findAll());
        return "invention_item";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id, @RequestParam("documentId") Long documentId){ //TODO: change to delete mapping
        inventionItemService.delete(id);
        return "redirect:/invention/" + documentId;
    }
}
