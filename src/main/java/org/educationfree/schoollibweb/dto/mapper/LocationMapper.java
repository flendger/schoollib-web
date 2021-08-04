package org.educationfree.schoollibweb.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationMapper implements Mapper<Location, LocationDto> {
    private final ModelMapper modelMapper;

    @Override
    public LocationDto entityToDto(Location entity) {
        return modelMapper.map(entity, LocationDto.class);
    }

    @Override
    public Location dtoToEntity(LocationDto dto) {
        return modelMapper.map(dto, Location.class);
    }
}
