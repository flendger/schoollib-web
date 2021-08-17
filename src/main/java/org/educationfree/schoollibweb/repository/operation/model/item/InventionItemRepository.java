package org.educationfree.schoollibweb.repository.operation.model.item;

import org.educationfree.schoollibweb.model.operation.Invention;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;
import org.springframework.stereotype.Repository;

@Repository
public interface InventionItemRepository extends OperationItemRepository<InventionItem, Invention>{
}
