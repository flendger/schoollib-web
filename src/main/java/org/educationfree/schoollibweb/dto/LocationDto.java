package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto extends AbstractCatalogDto {
    private LocationTypeDto locationType;
    private PersonDto person;

    public LocationDto(Long id, boolean isDeleted, Integer code, String name, LocationTypeDto locationTypeDto, PersonDto personDto) {
        super(id, isDeleted, code, name);
        this.locationType = locationTypeDto;
        this.person = personDto;
    }
}
