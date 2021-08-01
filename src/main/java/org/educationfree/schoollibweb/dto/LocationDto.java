package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto extends AbstractCatalogDto {
    private LocationTypeDto locationTypeDto;

    private PersonDto personDto;
}
