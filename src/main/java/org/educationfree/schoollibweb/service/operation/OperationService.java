package org.educationfree.schoollibweb.service.operation;

import java.util.List;
import java.util.Optional;

public interface OperationService<T> {
    List<T> findAll();
    List<T> findAllWithDeleted();
    Optional<T> findById(Long id);
    T getById(Long id);
    Optional<T> findByIdWithItems(Long id);
    T save(T entity);
    void delete(T entity);
    void deleteById(Long id);
    Optional<T> findLast();
    void setDeleted(Long id, boolean isDeleted);
}
