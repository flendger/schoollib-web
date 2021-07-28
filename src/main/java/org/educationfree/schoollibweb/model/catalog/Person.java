package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "people")
@Getter
@Setter
public class Person extends BaseCatalog{
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;
}
