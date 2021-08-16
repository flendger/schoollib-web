package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.educationfree.schoollibweb.model.BaseEntity;
import org.educationfree.schoollibweb.model.operation.item.BaseItemEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractOperation<I extends BaseItemEntity<?>> extends BaseEntity {
    @Column(name = "doc_num")
    protected Integer docNumber;

    @Column(name = "doc_date")
    protected LocalDateTime docDate;

    @OneToMany(mappedBy = "document", cascade = CascadeType.REMOVE, orphanRemoval = true)
    protected List<I> items;
}
