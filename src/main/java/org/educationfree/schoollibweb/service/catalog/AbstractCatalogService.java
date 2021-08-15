package org.educationfree.schoollibweb.service.catalog;

import org.educationfree.schoollibweb.model.catalog.AbstractCatalog;
import org.educationfree.schoollibweb.repository.catalog.CatalogRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCatalogService<T extends AbstractCatalog> implements CatalogService<T> {

    protected abstract CatalogRepository<T> getEntityRepository();

    @Override
    public List<T> findAll() {
        return getEntityRepository().findAll();
    }

    @Override
    public List<T> findAllByIsDeletedFalse() {
        return getEntityRepository().findAllByIsDeletedFalse();
    }

    @Override
    public Optional<T> findById(Long id) {
        return getEntityRepository().findById(id);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public T save(T entity) {
        if (entity.getId() == null && entity.getCode() == null) {
            T last = findLast().orElse(null);
            if (last == null) {
                //first element in catalog
                entity.setCode(1);
            } else {
                entity.setCode(last.getCode() + 1);
            }
        }
        return getEntityRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityRepository().delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        getEntityRepository().deleteById(id);
    }

    @Override
    public Optional<T> findLast() {
        return getEntityRepository().findTopByOrderByCodeDesc();
    }

    @Override
    @Transactional
    public void setDeleted(Long id, boolean isDeleted) throws EntityNotFoundException {
        CatalogRepository<T> repository = getEntityRepository();
        T entity = repository.getById(id);
        entity.setDeleted(isDeleted);
        repository.save(entity);
    }
}
