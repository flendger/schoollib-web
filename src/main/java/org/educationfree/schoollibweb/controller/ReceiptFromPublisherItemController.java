package org.educationfree.schoollibweb.controller;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.item.ReceiptFromPublisherItem;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.operation.item.OperationItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receipt_fp/item")
@RequiredArgsConstructor
public class ReceiptFromPublisherItemController {
    private final OperationItemService<ReceiptFromPublisherItem> entityService;
    private final CatalogService<Book, BookDto> bookService;

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        model.addAttribute("item", entityService.findById(id).orElseThrow());
        model.addAttribute("books", bookService.findAll());
        return "receipt_fp_item";
    }

    @PostMapping("/save")
    public String save(ReceiptFromPublisherItem item){
        entityService.save(item);
        return "redirect:/receipt_fp/" + item.getDocument().getId();
    }

    @GetMapping("/new")
    public String add(Model model, @RequestParam("document_id") Long documentId){
        model.addAttribute("item", entityService.newInstance(documentId));
        model.addAttribute("books", bookService.findAll());
        return "receipt_fp_item";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam("document_id") Long documentId){ //TODO: change to delete mapping
        entityService.delete(id);
        return "redirect:/receipt_fp/" + documentId;
    }
}
