package org.educationfree.schoollibweb.service.catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogService<D,T> {
    List<D> findAll();
    List<D> findAllByIsDeletedFalse();
    Optional<D> findById(Long id);
    D save(T entity);
    void delete(D dtoEntity);
    void deleteById(Long id);
    Optional<D> findLast();
}
