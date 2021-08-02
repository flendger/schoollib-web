package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.educationfree.schoollibweb.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractCatalog extends BaseEntity {
    @Column(name = "code")
    protected Integer code;

    @Column(name = "name")
    protected String name;

    public AbstractCatalog(Long id, boolean isDeleted, Integer code, String name) {
        super(id, isDeleted);
        this.code = code;
        this.name = name;
    }
}
