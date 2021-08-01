package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.educationfree.schoollibweb.model.catalog.AbstractCatalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
public class PersonDto extends AbstractCatalogDto {
    private String telephone;

    private String email;

    private String address;

    private String comment;
}
