package org.educationfree.schoollibweb.service.operation;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.ReceiptFromPublisher;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.educationfree.schoollibweb.repository.operation.model.ReceiptFromPublisherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptFromPublisherServiceImpl extends AbstractOperationService<ReceiptFromPublisher> {
    private final ReceiptFromPublisherRepository receiptFromPublisherRepository;

    @Override
    protected OperationRepository<ReceiptFromPublisher> getEntityRepository() {
        return receiptFromPublisherRepository;
    }
}
