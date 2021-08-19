package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @Transactional
    void renumberRows() {
        Long documentId = 1L;
        int bigRowNum = 10000;

        InventionItem newItem = inventionItemService.newInstance(documentId);
        newItem.setRow(bigRowNum);
        inventionItemService.save(newItem);

        List<InventionItem> items = inventionItemService.findAllByDocumentId(documentId);
        int maxRow = items.stream().mapToInt(InventionItem::getRow).max().orElse(-1);
        assertEquals(bigRowNum, maxRow);

        assertThrows(IllegalArgumentException.class, () -> inventionItemService.renumberRows(documentId, 0));

        assertDoesNotThrow(() -> inventionItemService.renumberRows(documentId, 1));
        List<InventionItem> renumberItems = inventionItemService.findAllByDocumentId(documentId);
        int maxRenumberRow = renumberItems.stream().mapToInt(InventionItem::getRow).max().orElse(-1);
        assertTrue(maxRenumberRow < bigRowNum);
    }

    @Test
    @Transactional
    void delete() {
        Long documentId = 1L;
        List<InventionItem> items = inventionItemService.findAllByDocumentId(documentId);
        int maxRow = items.stream().mapToInt(InventionItem::getRow).max().orElse(-1);
        assertTrue(maxRow > 0);

        inventionItemService.delete(items.get(0).getId());

        List<InventionItem> renumberItems = inventionItemService.findAllByDocumentId(documentId);
        int maxRenumberRow = renumberItems.stream().mapToInt(InventionItem::getRow).max().orElse(-1);
        assertEquals(maxRow - 1, maxRenumberRow);
    }
}