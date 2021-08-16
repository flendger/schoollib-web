package org.educationfree.schoollibweb.repository.operation;

import org.educationfree.schoollibweb.model.operation.AbstractOperation;
import org.educationfree.schoollibweb.repository.EntityRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface OperationRepository<T extends AbstractOperation<?>> extends EntityRepository<T> {
    Optional<T> findTopByOrderByDocNumberDesc();
}
