package org.educationfree.schoollibweb.service.operation.item;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.repository.operation.model.item.InventionItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventionItemService {
    private final InventionItemRepository inventionItemRepository;

    public Optional<InventionItem> findLast(Invention document) {
        return inventionItemRepository.findTopByDocumentOrderByRowDesc(document);
    }

    public List<InventionItem> findAllByDocument(Invention document) {
        return inventionItemRepository.findAllByDocument(document);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void save(InventionItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (item.getRow() == null) {
            item.setRow(getNewRowNum(item.getDocument()));
        }

        inventionItemRepository.save(item);
    }

    public int getNewRowNum(Invention document) {
        Optional<InventionItem> lastItemOptional = findLast(document);
        if (lastItemOptional.isPresent()) {
            InventionItem lastItem = lastItemOptional.get();
            return lastItem.getRow() + 1;
        }
        return 1;
    }

    public InventionItem getNewItem(Long id) {
        InventionItem item = new InventionItem();
        Invention document = new Invention();

        document.setId(id);
        item.setDocument(document);

        return item;
    }

    public InventionItem findById(Long id) {
        return inventionItemRepository.getById(id);
    }

    public void delete(Long id) {
        inventionItemRepository.deleteById(id);
    }
}
