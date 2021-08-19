package org.educationfree.schoollibweb.repository.operation.model.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface OperationItemRepository<I> extends JpaRepository<I, Long> {
    Optional<I> findTopByDocumentIdOrderByRowDesc(Long documentId);

    List<I> findAllByDocumentIdOrderByRow(Long documentId);

    List<I> findAllByDocumentIdAndRowGreaterThanEqualOrderByRow(Long documentId, int first);
}
