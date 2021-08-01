package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
public abstract class AbstractCatalogDto extends BaseEntity {

    protected Integer code;

    protected String name;
}
