package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements Mapper<Location, LocationDto>{
    final ModelMapper modelMapper;

    public LocationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationDto entityToDto(Location entity) {
        return modelMapper.map(entity,LocationDto.class);
    }

    @Override
    public Location dtoToEntity(LocationDto dto) {
        return modelMapper.map(dto, Location.class);
    }
}
