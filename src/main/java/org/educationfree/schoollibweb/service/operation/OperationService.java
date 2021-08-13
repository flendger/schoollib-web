package org.educationfree.schoollibweb.service.operation;

import java.util.List;
import java.util.Optional;

public interface OperationService<T> {
    List<T> findAll();
    List<T> findAllByIsDeletedFalse();
    Optional<T> findById(Long id);
    T save(T entity);
    void delete(T entity);
    void deleteById(Long id);
    Optional<T> findLast();
}
