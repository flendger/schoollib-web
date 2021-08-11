package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.LocationDto;
import org.educationfree.schoollibweb.dto.LocationTypeDto;
import org.educationfree.schoollibweb.dto.PersonDto;
import org.educationfree.schoollibweb.model.catalog.Location;
import org.educationfree.schoollibweb.model.catalog.LocationType;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LocationMapperTest {
    private ModelMapper modelMapper;

    @BeforeEach
    void init(){
        this.modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Location, LocationDto>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getLocationType(),destination.getLocationTypeDto());
                when(ctx -> ctx.getSource() == null ).skip(source.getPerson(),destination.getPersonDto());
            }
        });
        modelMapper.addMappings(new PropertyMap<LocationDto, Location>() {
            @Override
            protected void configure() {
                when(ctx -> ctx.getSource() == null ).skip(source.getLocationTypeDto(),destination.getLocationType());
                when(ctx -> ctx.getSource() == null ).skip(source.getPersonDto(),destination.getPerson());
            }
        });
    }

    @Test
    void dtoToEntity() {
        LocationMapper mapper = new LocationMapper(modelMapper);
        LocationDto locationDto = new LocationDto(1L, false, 1, "Location",
                new LocationTypeDto(1L, false, 1, "LocationType"),
                new PersonDto(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        Location actual = mapper.dtoToEntity(locationDto);
        assertNotNull(actual);
        Location expected = new Location(1L, false, 1, "Location",
                new LocationType(1L, false, 1, "LocationType"),
                new Person(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        assertEquals(expected, actual);
    }

    @Test
    void dtoToEntityWithNullSourceProperty() {
        LocationMapper mapper = new LocationMapper(modelMapper);
        LocationDto locationDto = new LocationDto(1L, false, 1, "Location",
                null,
                new PersonDto(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        Location actual = mapper.dtoToEntity(locationDto);
        assertNotNull(actual);
        Location expected = new Location(1L, false, 1, "Location",
                null,
                new Person(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        assertEquals(expected, actual);
    }


    @Test
    void entityToDto() {
        LocationMapper mapper = new LocationMapper(modelMapper);
        Location location = new Location(1L, false, 1, "Location",
                new LocationType(1L, false, 1, "LocationType"),
                new Person(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        LocationDto actual = mapper.entityToDto(location);
        assertNotNull(actual);

        LocationDto  expected = new LocationDto(1L, false, 1, "Location",
                new LocationTypeDto(1L, false, 1, "LocationType"),
                new PersonDto(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        assertEquals(expected, actual);
    }

    @Test
    void entityToDtoWithNullSourceProperty() {
        LocationMapper mapper = new LocationMapper(modelMapper);
        Location location = new Location(1L, false, 1, "Location",
                null,
                new Person(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        LocationDto actual = mapper.entityToDto(location);
        assertNotNull(actual);

        LocationDto  expected = new LocationDto(1L, false, 1, "Location",
                null,
                new PersonDto(1L, false, 1, "Petr", "111", "1@2.com", "Some address", "Some comment"));
        assertEquals(expected, actual);
    }
}