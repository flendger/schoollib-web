package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.catalog.Publisher;
import org.educationfree.schoollibweb.model.operation.item.ReceiptFromPublisherItem;

import javax.persistence.*;

@Entity
@Table(name = "receipts_from_publisher")
@Getter
@Setter
public class ReceiptFromPublisher extends AbstractOperation<ReceiptFromPublisherItem>{
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
