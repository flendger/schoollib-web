package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class InventionItemServiceTest {
    @Autowired
    private InventionItemService inventionItemService;

    @Test
    void findLast() {
        Invention invention = new Invention();
        invention.setId(1L);
        assertDoesNotThrow(() -> inventionItemService.findLast(invention));
    }

    @Test
    void findAllByDocument() {
        Invention invention = new Invention();
        invention.setId(1L);
        assertDoesNotThrow(() -> inventionItemService.findAllByDocument(invention));
    }

    @Test
    @Transactional
    void save() {
        Invention invention = new Invention();
        invention.setId(1L);

        InventionItem newItem = inventionItemService.getNewItem(invention);

        Book book = new Book();
        book.setId(66L);
        newItem.setBook(book);
        newItem.setQuantity(55);

        assertDoesNotThrow(() -> inventionItemService.save(newItem));
        assertNotNull(newItem.getId());
        assertNotNull(newItem.getRow());
        System.out.println(newItem);
    }
}