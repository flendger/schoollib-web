package org.educationfree.schoollibweb.service.operation.item;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.repository.operation.model.item.OperationItemRepository;
import org.educationfree.schoollibweb.service.operation.OperationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventionItemService extends AbstractOperationItemService<InventionItem>{
    private final OperationItemRepository<InventionItem> inventionItemRepository;
    private final OperationService<Invention> operationService;

    @Override
    protected OperationItemRepository<InventionItem> getEntityRepository() {
        return inventionItemRepository;
    }

    public InventionItem getNewItem(Long documentId) {
        InventionItem item = new InventionItem();
        item.setDocument(operationService.getById(documentId));

        return item;
    }
}
