package org.educationfree.schoollibweb.service.operation.item;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.repository.operation.model.item.OperationItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventionItemService extends AbstractOperationItemService<InventionItem, Invention>{
    private final OperationItemRepository<InventionItem, Invention> inventionItemRepository;

    @Override
    protected OperationItemRepository<InventionItem, Invention> getEntityRepository() {
        return inventionItemRepository;
    }

    public InventionItem getNewItem(Invention document) {
        InventionItem item = new InventionItem();
        item.setDocument(document);

        return item;
    }
}
