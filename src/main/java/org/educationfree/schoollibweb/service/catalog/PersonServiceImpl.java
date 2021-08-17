package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.PersonDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.repository.catalog.model.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractCatalogService<Person, PersonDto> {
    private final PersonRepository personRepository;
    private final Mapper<Person, PersonDto> mapper;

    @Override
    protected PersonRepository getEntityRepository() {
        return personRepository;
    }

    @Override
    protected Mapper<Person, PersonDto> getMapper() {
        return mapper;
    }
}
