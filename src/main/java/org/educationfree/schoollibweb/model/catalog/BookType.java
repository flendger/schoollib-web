package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book_types")
@Getter
@Setter
@NoArgsConstructor
public class BookType extends AbstractCatalog {
    public BookType(Long id, boolean isDeleted, Integer code, String name) {
        super(id, isDeleted, code, name);
    }
}
