package org.educationfree.schoollibweb.service.catalog;

import org.educationfree.schoollibweb.dto.BookTypeDto;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class AbstractCatalogServiceTest {
    @Autowired
    private CatalogService<BookType, BookTypeDto> catalogService;

    @Test
    void setDeleted() {
        assertThrows(EntityNotFoundException.class, () -> catalogService.setDeleted(555L, true));
    }
}