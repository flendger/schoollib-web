package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.repository.catalog.model.BookTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookTypeServiceImpl extends AbstractCatalogService<BookType> {
    private final BookTypeRepository bookTypeRepository;

    @Override
    protected BookTypeRepository getEntityRepository() {
        return bookTypeRepository;
    }
}
