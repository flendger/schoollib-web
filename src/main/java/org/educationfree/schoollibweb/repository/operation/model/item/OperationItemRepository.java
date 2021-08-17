package org.educationfree.schoollibweb.repository.operation.model.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface OperationItemRepository<I, T> extends JpaRepository<I, Long> {
    Optional<I> findTopByDocumentOrderByRowDesc(T document);

    List<I> findAllByDocument(T document);
}
