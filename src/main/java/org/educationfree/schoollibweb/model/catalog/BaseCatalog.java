package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseCatalog extends BaseEntity {
    @Column(name = "code")
    protected Integer code;

    @Column(name = "name")
    protected String name;
}
