package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;
import org.educationfree.schoollibweb.repository.operation.model.item.OperationItemRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractOperationItemService<I extends BaseItemEntity<?>> implements OperationItemService<I> {
    protected abstract OperationItemRepository<I> getEntityRepository();

    @Override
    public Optional<I> findLast(Long documentId) {
        return getEntityRepository().findTopByDocumentIdOrderByRowDesc(documentId);
    }

    @Override
    public List<I> findAllByDocumentId(Long documentId) {
        return getEntityRepository().findAllByDocumentId(documentId);
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
}
