package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.operation.AbstractOperation;
import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;

import java.util.List;
import java.util.Optional;

public interface OperationItemService<I extends BaseItemEntity<T>, T extends AbstractOperation<I>> {
    Optional<I> findLast(T document);
    List<I> findAllByDocument(T document);
    void save(I item);
    int getNewRowNum(T document);
    I getNewItem(T document);
}
