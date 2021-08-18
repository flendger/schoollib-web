package org.educationfree.schoollibweb.service.operation.item;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.ReceiptFromPublisher;
import org.educationfree.schoollibweb.model.operation.item.ReceiptFromPublisherItem;
import org.educationfree.schoollibweb.repository.operation.model.item.OperationItemRepository;
import org.educationfree.schoollibweb.service.operation.OperationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptFromPublisherItemService extends AbstractOperationItemService<ReceiptFromPublisherItem>{
    private final OperationItemRepository<ReceiptFromPublisherItem> receiptFromPublisherItemRepository;
    private final OperationService<ReceiptFromPublisher> operationService;

    @Override
    protected OperationItemRepository<ReceiptFromPublisherItem> getEntityRepository() {
        return receiptFromPublisherItemRepository;
    }

    @Override
    public ReceiptFromPublisherItem newInstance(Long documentId) {
        ReceiptFromPublisherItem item = new ReceiptFromPublisherItem();
        item.setDocument(operationService.getById(documentId));
        return item;
    }
}
