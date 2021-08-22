package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
public class Person extends AbstractCatalog {
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;

    public Person(Long id, boolean isDeleted, Integer code, String name, String telephone, String email, String address, String comment) {
        super(id, isDeleted, code, name);
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.comment = comment;
    }
}
