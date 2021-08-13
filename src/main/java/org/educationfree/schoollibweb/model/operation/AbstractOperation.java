package org.educationfree.schoollibweb.model.operation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.educationfree.schoollibweb.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractOperation extends BaseEntity {
    @Column(name = "doc_num")
    private int docNumber;

    @Column(name = "doc_date")
    private LocalDateTime docDate;
}
