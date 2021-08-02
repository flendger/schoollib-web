package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.PersonDto;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<Person, PersonDto>{
    final ModelMapper modelMapper;

    public PersonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDto entityToDto(Person entity) {
        return modelMapper.map(entity,PersonDto.class);
    }

    @Override
    public Person dtoToEntity(PersonDto dto) {
        return modelMapper.map(dto,Person.class);
    }
}
