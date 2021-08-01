package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.repository.catalog.model.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends AbstractCatalogService<Book> {
    private final BookRepository bookRepository;

    @Override
    protected BookRepository getEntityRepository() {
        return bookRepository;
    }
}
