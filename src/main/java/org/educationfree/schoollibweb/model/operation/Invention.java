package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.journal.LocationStockEntry;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventions")
@Getter
@Setter
public class Invention extends AbstractOperation<InventionItem>{
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "inventions_location_stocks",
            joinColumns = @JoinColumn(name = "doc_id"),
            inverseJoinColumns = @JoinColumn(name = "entry_id")
    )
    private List<LocationStockEntry> locationStockEntries;
}
