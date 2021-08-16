package org.educationfree.schoollibweb.service.operation.item;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.repository.operation.model.item.InventionItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventionItemService {
    private final InventionItemRepository inventionItemRepository;

    public Optional<InventionItem> findLast(Invention invention) {
        return inventionItemRepository.findTopByDocumentOrderByRowDesc(invention);
    }

    public List<InventionItem> findAllByDocument(Invention invention) {
        return inventionItemRepository.findAllByDocument(invention);
    }
}
