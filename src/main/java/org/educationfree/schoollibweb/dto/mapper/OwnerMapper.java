package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.OwnerDto;
import org.educationfree.schoollibweb.model.catalog.Owner;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements Mapper<Owner, OwnerDto>{
    final ModelMapper modelMapper;

    public OwnerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerDto entityToDto(Owner entity) {
        return modelMapper.map(entity,OwnerDto.class);
    }

    @Override
    public Owner dtoToEntity(OwnerDto dto) {
        return modelMapper.map(dto,Owner.class);
    }
}
