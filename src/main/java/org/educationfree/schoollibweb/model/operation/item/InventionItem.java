package org.educationfree.schoollibweb.model.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.Invention;

import javax.persistence.*;

@Entity
@Table(name = "invention_items")
@Getter
@Setter
public class InventionItem extends BaseItemEntity<Invention>{
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "quantity")
    private int quantity;
}
