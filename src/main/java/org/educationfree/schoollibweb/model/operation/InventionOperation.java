package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventions")
@Getter
@Setter
public class InventionOperation extends AbstractOperation{
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventionItem> items;
}
