package org.educationfree.schoollibweb.service.operation.item;

import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;

import java.util.List;
import java.util.Optional;

public interface OperationItemService<I extends BaseItemEntity<?>> {
    Optional<I> findLast(Long documentId);
    List<I> findAllByDocumentId(Long documentId);
    void save(I item);
    int getNewRowNum(Long documentId);
    I getNewItem(Long documentId);
}
