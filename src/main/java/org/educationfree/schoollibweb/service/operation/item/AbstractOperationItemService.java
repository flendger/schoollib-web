package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.operation.AbstractOperation;
import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;
import org.educationfree.schoollibweb.repository.operation.model.item.OperationItemRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractOperationItemService<I extends BaseItemEntity<T>, T extends AbstractOperation<I>> implements OperationItemService<I, T> {
    protected abstract OperationItemRepository<I, T> getEntityRepository();

    @Override
    public Optional<I> findLast(T document) {
        return getEntityRepository().findTopByDocumentOrderByRowDesc(document);
    }

    @Override
    public List<I> findAllByDocument(T document) {
        return getEntityRepository().findAllByDocument(document);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void save(I item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (item.getRow() == null) {
            item.setRow(getNewRowNum(item.getDocument()));
        }

        getEntityRepository().save(item);
    }

    @Override
    public int getNewRowNum(T document) {
        Optional<I> lastItemOptional = findLast(document);
        if (lastItemOptional.isPresent()) {
            I lastItem = lastItemOptional.get();
            return lastItem.getRow() + 1;
        }
        return 1;
    }
}
