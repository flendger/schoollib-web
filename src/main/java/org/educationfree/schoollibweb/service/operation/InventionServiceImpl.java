package org.educationfree.schoollibweb.service.operation;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.InventionOperation;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.educationfree.schoollibweb.repository.operation.model.InventionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventionServiceImpl extends AbstractOperationService<InventionOperation> {
    private final InventionRepository inventionRepository;

    @Override
    protected OperationRepository<InventionOperation> getEntityRepository() {
        return inventionRepository;
    }
}
