package org.educationfree.schoollibweb.service.operation;

import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class InventionServiceImplTest {
    @Autowired
    private OperationService<Invention> operationService;

    @Test
    void findByIdWithItems() {
        Optional<Invention> optionalInvention = operationService.findByIdWithItems(1L);
        assertTrue(optionalInvention.isPresent());

        Invention document = optionalInvention.get();
        List<InventionItem> items = document.getItems();
        assertDoesNotThrow(items::size);
        assertTrue(items.size() > 0);
        assertNotNull(items.get(0).getBook());
    }

    @Test
    @Transactional
    void save() {
        Optional<Invention> optionalInvention = operationService.findByIdWithItems(1L);
        assertTrue(optionalInvention.isPresent());

        Invention invention = optionalInvention.get();
        assertNotNull(invention.getItems());
        int linesCount = invention.getItems().size();
        assertTrue(linesCount > 0);

        Book book = new Book();
        book.setId(80L);
        InventionItem newItem = new InventionItem();
        newItem.setDocument(invention);
        newItem.setBook(book);
        newItem.setQuantity(555);

        invention.getItems().add(newItem);
        operationService.save(invention);

        Optional<Invention> optionalSavedInvention = operationService.findByIdWithItems(invention.getId());
        assertTrue(optionalSavedInvention.isPresent());

        Invention savedInvention = optionalSavedInvention.get();
        List<InventionItem> savedItems = savedInvention.getItems();
        assertNotNull(savedItems);
        assertEquals(linesCount + 1, savedItems.size());
    }
}