package org.educationfree.schoollibweb.service.operation;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.journal.LocationStockEntry;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.educationfree.schoollibweb.repository.operation.model.InventionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventionServiceImpl extends AbstractOperationService<Invention> {
    private final InventionRepository inventionRepository;

    @Override
    protected OperationRepository<Invention> getEntityRepository() {
        return inventionRepository;
    }

    @Override
    @Transactional
    public Invention save(Invention entity) {
        fillHeader(entity);

        List<InventionItem> items = entity.getItems();
        renumberRows(items);

        entity.setLocationStockEntries(makeLocationStockEntries(entity));

        return getEntityRepository().save(entity);
    }

    private List<LocationStockEntry> makeLocationStockEntries(Invention entity) {
        List<InventionItem> items = entity.getItems();
        if (items == null) {
            return Collections.emptyList();
        }

        return items
                .stream()
                .filter(item -> item.getBook() != null)
                .map(item -> {
                    LocationStockEntry locationStockEntry = new LocationStockEntry();
                    locationStockEntry.setEntryDate(entity.getDocDate());
                    locationStockEntry.setLocation(entity.getLocation());
                    locationStockEntry.setBook(item.getBook());
                    locationStockEntry.setQuantity(item.getQuantity());
                    return locationStockEntry;
                })
                .collect(Collectors.toList());
    }
}
