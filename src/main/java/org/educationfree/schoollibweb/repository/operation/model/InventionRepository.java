package org.educationfree.schoollibweb.repository.operation.model;

import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventionRepository extends OperationRepository<Invention> {
}
