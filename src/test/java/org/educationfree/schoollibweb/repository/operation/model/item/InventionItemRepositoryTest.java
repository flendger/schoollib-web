package org.educationfree.schoollibweb.repository.operation.model.item;

import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class InventionItemRepositoryTest {
    @Autowired
    private OperationItemRepository<InventionItem> inventionItemOperationRepository;

    @Test
    void findAllByDocumentIdAndRowGreaterThanEqualOrderByRow() {
        assertDoesNotThrow(() -> inventionItemOperationRepository.findAllByDocumentIdAndRowGreaterThanEqualOrderByRow(1L, 1));
    }
}