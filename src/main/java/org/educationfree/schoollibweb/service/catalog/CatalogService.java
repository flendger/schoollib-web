package org.educationfree.schoollibweb.service.catalog;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CatalogService<T,D> {
    List<D> findAll();
    List<D> findAllByIsDeletedFalse();
    Optional<D> findById(Long id);
    D save(D entity);
    void delete(D dtoEntity);
    void deleteById(Long id);
    void setDeleted(Long id, boolean isDeleted);
    Optional<D> findLast();

    List<D> findByName(@Param("t") String t);

}
