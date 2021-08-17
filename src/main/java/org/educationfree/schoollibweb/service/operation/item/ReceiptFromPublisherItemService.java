package org.educationfree.schoollibweb.service.operation.item;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.ReceiptFromPublisher;
import org.educationfree.schoollibweb.model.operation.item.ReceiptFromPublisherItem;
import org.educationfree.schoollibweb.repository.operation.model.item.ReceiptFromPublisherItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceiptFromPublisherItemService {
    private final ReceiptFromPublisherItemRepository receiptFromPublisherItemRepository;

    public Optional<ReceiptFromPublisherItem> findLast(ReceiptFromPublisher document) {
        return receiptFromPublisherItemRepository.findTopByDocumentOrderByRowDesc(document);
    }

    public List<ReceiptFromPublisherItem> findAllByDocument(ReceiptFromPublisher document) {
        return receiptFromPublisherItemRepository.findAllByDocument(document);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void save(ReceiptFromPublisherItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (item.getRow() == null) {
            item.setRow(getNewRowNum(item.getDocument()));
        }

        receiptFromPublisherItemRepository.save(item);
    }

    public int getNewRowNum(ReceiptFromPublisher document) {
        Optional<ReceiptFromPublisherItem> lastItemOptional = findLast(document);
        if (lastItemOptional.isPresent()) {
            ReceiptFromPublisherItem lastItem = lastItemOptional.get();
            return lastItem.getRow() + 1;
        }
        return 1;
    }

    public ReceiptFromPublisherItem getNewItem(ReceiptFromPublisher document) {
        ReceiptFromPublisherItem item = new ReceiptFromPublisherItem();
        item.setDocument(document);

        return item;
    }
}
