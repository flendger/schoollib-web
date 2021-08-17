package org.educationfree.schoollibweb.repository.operation.model.item;

import org.educationfree.schoollibweb.model.operation.ReceiptFromPublisher;
import org.educationfree.schoollibweb.model.operation.item.ReceiptFromPublisherItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceiptFromPublisherItemRepository extends JpaRepository<ReceiptFromPublisherItem, Long> {
    Optional<ReceiptFromPublisherItem> findTopByDocumentOrderByRowDesc(ReceiptFromPublisher document);

    List<ReceiptFromPublisherItem> findAllByDocument(ReceiptFromPublisher document);
}
