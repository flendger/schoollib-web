package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
@Getter
@Setter
public class Publisher extends BaseCatalog{
}
