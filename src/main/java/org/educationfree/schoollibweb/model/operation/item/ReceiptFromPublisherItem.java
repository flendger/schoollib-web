package org.educationfree.schoollibweb.model.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.operation.ReceiptFromPublisher;

import javax.persistence.*;

@Entity
@Table(name = "receipt_from_publisher_items")
@Getter
@Setter
public class ReceiptFromPublisherItem extends BaseItemEntity<ReceiptFromPublisher>{
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "quantity")
    private int quantity;
}
