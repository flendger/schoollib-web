package org.educationfree.schoollibweb.service.operation;

import org.educationfree.schoollibweb.model.operation.AbstractOperation;
import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractOperationService<T extends AbstractOperation<?>> implements OperationService<T> {

    protected abstract OperationRepository<T> getEntityRepository();

    @Override
    public List<T> findAll() {
        return getEntityRepository().findAllByIsDeletedFalse();
    }

    @Override
    public List<T> findAllWithDeleted() {
        return getEntityRepository().findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return getEntityRepository().findById(id);
    }

    @Override
    public T getById(Long id) {
        return getEntityRepository().getById(id);
    }

    @Override
    @Transactional
    public Optional<T> findByIdWithItems(Long id) {
        Optional<T> docOptional = getEntityRepository().findById(id);
        if (docOptional.isPresent()) {
            T document = docOptional.get();
            Hibernate.initialize(document.getItems());
        }
        return docOptional;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public T save(T entity) { //TODO: Update document when items changed and saved
        OperationRepository<T> repository = getEntityRepository();
        T entityToSave = entity;
        if (entity.getId() != null) {
            T existEntity = repository.findById(entity.getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            String.format("Entity %s with id %d not found", entity.getClass().getSimpleName(), entity.getId())));
            entityToSave = mergeEntity(existEntity, entity);
        }

        fillHeader(entityToSave);
        renumberRows(entityToSave.getItems());
        makeEntries(entityToSave);

        return repository.save(entityToSave);
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

    @Override
    @Transactional
    public void setDeleted(Long id, boolean isDeleted) throws EntityNotFoundException {
        OperationRepository<T> repository = getEntityRepository();
        T entity = repository.getById(id);
        entity.setDeleted(isDeleted);
        repository.save(entity);
    }

    protected void fillHeader(T entity) {
        if (entity.getId() == null && entity.getDocNumber() == null) {
            T last = findLast().orElse(null);
            if (last == null) {
                //first element in operation
                entity.setDocNumber(1);
            } else {
                entity.setDocNumber(last.getDocNumber() + 1);
            }
        }
        if (entity.getDocDate() == null) {
            entity.setDocDate(LocalDateTime.now());
        }
    }

    protected void renumberRows(List<? extends BaseItemEntity<?>> items) {
        if (items == null) {
            return;
        }

        AtomicInteger rowCounter = new AtomicInteger();
        items
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(item -> item.getRow() == null ? Integer.MAX_VALUE : item.getRow()))
                .forEach(item -> item.setRow(rowCounter.incrementAndGet()));
    }

    protected T mergeEntity(T existEntity, T entity) {
        existEntity.setDocDate(entity.getDocDate());
        existEntity.setDocNumber(entity.getDocNumber());
        existEntity.setDeleted(entity.isDeleted());
        return existEntity;
    }

    protected void makeEntries(T entity) {
    }
}
