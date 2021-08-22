package org.educationfree.schoollibweb.service.operation;

import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
}