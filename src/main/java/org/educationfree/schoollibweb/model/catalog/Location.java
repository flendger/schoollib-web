package org.educationfree.schoollibweb.model.catalog;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
public class Location extends BaseCatalog{
    @ManyToOne
    @JoinColumn(name = "location_type_id")
    private LocationType locationType;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
