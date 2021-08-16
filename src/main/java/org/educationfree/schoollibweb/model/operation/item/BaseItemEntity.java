package org.educationfree.schoollibweb.model.operation.item;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.operation.AbstractOperation;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseItemEntity<T extends AbstractOperation> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "row_num")
    private Integer row;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private T document;
}
