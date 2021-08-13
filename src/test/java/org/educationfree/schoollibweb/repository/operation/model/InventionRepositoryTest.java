package org.educationfree.schoollibweb.repository.operation.model;

import org.educationfree.schoollibweb.model.operation.InventionOperation;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("dev")
class InventionRepositoryTest {
    @Autowired
    private InventionRepository inventionRepository;

    @Test
    void getLastByNumber() {
        Optional<InventionOperation> inventionOperation = inventionRepository.findTopByOrderByDocNumberDesc();
        assertEquals(Optional.class, inventionOperation.getClass());
    }
}