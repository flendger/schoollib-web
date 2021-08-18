package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("dev")
class InventionItemServiceTest {
    @Autowired
    private InventionItemService inventionItemService;

    @Test
    void findLast() {
        assertDoesNotThrow(() -> inventionItemService.findLast(1L));
    }

    @Test
    void findAllByDocument() {
        assertDoesNotThrow(() -> inventionItemService.findAllByDocumentId(1L));
    }

    @Test
    @Transactional
    void save() {
        InventionItem newItem = inventionItemService.newInstance(1L);

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