package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.repository.catalog.model.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractCatalogService<Person> {
    private final PersonRepository personRepository;

    @Override
    protected PersonRepository getEntityRepository() {
        return personRepository;
    }
}
