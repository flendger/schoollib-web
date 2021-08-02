package org.educationfree.schoollibweb.model.catalog;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
public class Location extends AbstractCatalog {
    @ManyToOne
    @JoinColumn(name = "location_type_id")
    private LocationType locationType;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Location(Long id, boolean isDeleted, Integer code, String name, LocationType locationType, Person person) {
        super(id, isDeleted, code, name);
        this.locationType = locationType;
        this.person = person;
    }
}
