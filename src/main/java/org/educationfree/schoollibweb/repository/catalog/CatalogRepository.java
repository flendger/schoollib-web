package org.educationfree.schoollibweb.repository.catalog;

import org.educationfree.schoollibweb.model.catalog.AbstractCatalog;
import org.educationfree.schoollibweb.repository.EntityRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CatalogRepository<T extends AbstractCatalog> extends EntityRepository<T> {
    Optional<T> findTopByOrderByCodeDesc();
}
