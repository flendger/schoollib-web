package org.educationfree.schoollibweb.repository.operation.model.item;

import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventionItemRepository extends JpaRepository<InventionItem, Long> {
    Optional<InventionItem> findTopByDocumentOrderByRowDesc(Invention invention);

    List<InventionItem> findAllByDocument(Invention invention);
}
