package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.LocationTypeDto;
import org.educationfree.schoollibweb.model.catalog.LocationType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LocationTypeMapper implements Mapper<LocationType, LocationTypeDto> {
    final ModelMapper modelMapper;

    public LocationTypeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationTypeDto entityToDto(LocationType entity) {
        return modelMapper.map(entity,LocationTypeDto.class);
    }

    @Override
    public LocationType dtoToEntity(LocationTypeDto dto) {
        return modelMapper.map(dto,LocationType.class);
    }
}
