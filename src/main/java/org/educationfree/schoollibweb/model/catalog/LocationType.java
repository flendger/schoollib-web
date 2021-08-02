package org.educationfree.schoollibweb.model.catalog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location_types")
@Getter
@Setter
@NoArgsConstructor
public class LocationType extends AbstractCatalog {
    public LocationType(Long id, boolean isDeleted, Integer code, String name) {
        super(id, isDeleted, code, name);
    }
}
