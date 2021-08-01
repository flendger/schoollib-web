package org.educationfree.schoollibweb.repository.catalog.model;

import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.repository.catalog.CatalogRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CatalogRepository<Book> {
}
