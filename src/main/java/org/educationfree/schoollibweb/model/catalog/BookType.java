package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book_types")
@Getter
@Setter
public class BookType extends AbstractCatalog {

}
