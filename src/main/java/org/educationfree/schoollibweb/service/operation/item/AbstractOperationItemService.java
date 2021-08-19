package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;
import org.educationfree.schoollibweb.repository.operation.model.item.OperationItemRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractOperationItemService<I extends BaseItemEntity<?>> implements OperationItemService<I> {
    protected abstract OperationItemRepository<I> getEntityRepository();

    @Override
    public Optional<I> findLast(Long documentId) {
        return getEntityRepository().findTopByDocumentIdOrderByRowDesc(documentId);
    }

    @Override
    public Optional<I> findById(Long id) {
        return getEntityRepository().findById(id);
    }

    @Override
    public List<I> findAllByDocumentId(Long documentId) {
        return getEntityRepository().findAllByDocumentIdOrderByRow(documentId);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void save(I item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (item.getRow() == null) {
            item.setRow(getNewRowNum(item.getDocument().getId()));
        }

        getEntityRepository().save(item);
    }

    @Override
    public int getNewRowNum(Long documentId) {
        Optional<I> lastItemOptional = findLast(documentId);
        if (lastItemOptional.isPresent()) {
            I lastItem = lastItemOptional.get();
            return lastItem.getRow() + 1;
        }
        return 1;
    }

    @Override
    public void delete(Long id) {
        getEntityRepository().deleteById(id);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void renumberRows(Long documentId, int first) {
        if (documentId == null) {
            throw new IllegalArgumentException("documentId mustn't be null");
        }
        if (first < 1) {
            throw new IllegalArgumentException("First row must be greater than 0");
        }

        OperationItemRepository<I> entityRepository = getEntityRepository();

        List<I> items = entityRepository.findAllByDocumentIdAndRowGreaterThanEqualOrderByRow(documentId, first);
        AtomicInteger counter = new AtomicInteger(first -1);
        items.forEach(item -> item.setRow(counter.incrementAndGet()));

        entityRepository.saveAll(items);
    }
}
