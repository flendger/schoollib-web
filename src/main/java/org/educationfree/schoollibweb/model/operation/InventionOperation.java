package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.operation.item.InventionItem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class InventionOperation extends AbstractOperation{
    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventionItem> items;
}
