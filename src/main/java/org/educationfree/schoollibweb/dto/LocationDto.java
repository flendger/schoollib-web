package org.educationfree.schoollibweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto extends AbstractCatalogDto {
    private LocationTypeDto locationTypeDto;

    private PersonDto personDto;

}
