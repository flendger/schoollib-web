package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.*;
import org.educationfree.schoollibweb.model.catalog.*;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    @Test
    void entityToDto() {
        PersonMapper mapper = new PersonMapper(new ModelMapper());
        Person person = new Person(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment");
        PersonDto actual = mapper.entityToDto(person);
        assertNotNull(actual);
        PersonDto expected = new PersonDto(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment");
        assertEquals(expected, actual);
    }

    @Test
    void dtoToEntity() {
        PersonMapper mapper = new PersonMapper(new ModelMapper());
        PersonDto personDto = new PersonDto(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment");
        Person actual = mapper.dtoToEntity(personDto);
        assertNotNull(actual);
        Person expected = new Person(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment");
        assertEquals(expected, actual);
    }
}