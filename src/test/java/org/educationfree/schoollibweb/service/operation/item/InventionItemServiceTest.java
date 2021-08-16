package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.operation.Invention;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
        inventionItemService.findLast(invention);
        inventionItemService.findAllByDocument(invention);
    }
}