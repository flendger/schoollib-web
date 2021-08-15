package org.educationfree.schoollibweb.service.operation;

import org.educationfree.schoollibweb.model.operation.AbstractOperation;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractOperationService<T extends AbstractOperation> implements OperationService<T> {

    protected abstract OperationRepository<T> getEntityRepository();

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
    public T save(T entity) {
        if (entity.getId() == null && entity.getDocNumber() == null) {
            T last = findLast().orElse(null);
            if (last == null) {
                //first element in operation
                entity.setDocNumber(1);
            } else {
                entity.setDocNumber(last.getDocNumber() + 1);
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
        return getEntityRepository().findTopByOrderByDocNumberDesc();
    }
}
