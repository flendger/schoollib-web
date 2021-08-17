package org.educationfree.schoollibweb.service.operation;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.educationfree.schoollibweb.repository.operation.model.InventionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventionServiceImpl extends AbstractOperationService<Invention> {
    private final InventionRepository inventionRepository;

    @Override
    protected OperationRepository<Invention> getEntityRepository() {
        return inventionRepository;
    }
}
