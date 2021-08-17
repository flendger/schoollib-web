package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;

import javax.persistence.*;

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
}
