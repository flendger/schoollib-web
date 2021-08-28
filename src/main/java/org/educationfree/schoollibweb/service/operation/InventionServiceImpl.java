package org.educationfree.schoollibweb.service.operation;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.journal.LocationStockEntry;
import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.educationfree.schoollibweb.repository.operation.OperationRepository;
import org.educationfree.schoollibweb.repository.operation.model.InventionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventionServiceImpl extends AbstractOperationService<Invention> {
    private final InventionRepository inventionRepository;

    @Override
    protected OperationRepository<Invention> getEntityRepository() {
        return inventionRepository;
    }

    @Override
    protected Invention mergeEntity(Invention existEntity, Invention entity) {
        existEntity = super.mergeEntity(existEntity, entity);

        existEntity.setLocation(entity.getLocation());
        existEntity.setComment(entity.getComment());
        return existEntity;
    }

    @Override
    protected void makeEntries(Invention entity) {
        super.makeEntries(entity);
        entity.setLocationStockEntries(makeLocationStockEntries(entity));
    }

    private List<LocationStockEntry> makeLocationStockEntries(Invention entity) {
        final List<LocationStockEntry> locationStockEntries;
        if (entity.getLocationStockEntries() == null) {
            locationStockEntries = new ArrayList<>();
        } else {
            locationStockEntries = entity.getLocationStockEntries();
            locationStockEntries.clear();
        }

        List<InventionItem> items = entity.getItems();
        if (items == null) {
            return locationStockEntries;
        }

        items
                .stream()
                .filter(item -> item.getBook() != null)
                .forEach(item -> {
                    LocationStockEntry locationStockEntry = new LocationStockEntry();
                    locationStockEntry.setEntryDate(entity.getDocDate());
                    locationStockEntry.setLocation(entity.getLocation());
                    locationStockEntry.setBook(item.getBook());
                    locationStockEntry.setQuantity(item.getQuantity());
                    locationStockEntries.add(locationStockEntry);
                });
        return locationStockEntries;
    }
}
