package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto extends AbstractCatalogDto {
    private LocationTypeDto locationTypeDto;

    private PersonDto personDto;

    public LocationDto(Long id, boolean isDeleted, Integer code, String name, LocationTypeDto locationTypeDto, PersonDto personDto) {
        super(id, isDeleted, code, name);
        this.locationTypeDto = locationTypeDto;
        this.personDto = personDto;
    }
}
