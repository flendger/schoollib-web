package org.educationfree.schoollibweb.model.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.InventionOperation;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InventionItem extends BaseItemEntity<InventionOperation>{
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "quantity")
    private int quantity;
}
