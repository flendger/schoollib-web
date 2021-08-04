package org.educationfree.schoollibweb.repository.catalog.model;

import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.repository.catalog.CatalogRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CatalogRepository<Person> {
}
