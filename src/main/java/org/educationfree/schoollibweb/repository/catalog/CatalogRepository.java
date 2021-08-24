package org.educationfree.schoollibweb.repository.catalog;

import org.educationfree.schoollibweb.model.catalog.AbstractCatalog;
import org.educationfree.schoollibweb.repository.EntityRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CatalogRepository<T extends AbstractCatalog> extends EntityRepository<T> {
    Optional<T> findTopByOrderByCodeDesc();

    List<T> findByName(@Param("t") String t);
    List<T> findByTName(@Param("t") String t);
}
