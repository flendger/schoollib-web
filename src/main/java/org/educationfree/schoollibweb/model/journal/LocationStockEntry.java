package org.educationfree.schoollibweb.model.journal;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.model.catalog.Location;

import javax.persistence.*;

@Entity
@Table(name = "location_stocks")
@Getter
@Setter
public class LocationStockEntry extends BaseEntry {
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "quantity")
    private int quantity;
}
