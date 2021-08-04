package org.educationfree.schoollibweb.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.PersonDto;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper implements Mapper<Person, PersonDto> {
    private final ModelMapper modelMapper;

    @Override
    public PersonDto entityToDto(Person entity) {
        return modelMapper.map(entity, PersonDto.class);
    }

    @Override
    public Person dtoToEntity(PersonDto dto) {
        return modelMapper.map(dto, Person.class);
    }
}
