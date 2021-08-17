package org.educationfree.schoollibweb.service.catalog;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookTypeDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.repository.catalog.model.BookTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookTypeServiceImpl extends AbstractCatalogService<BookType, BookTypeDto> {
    private final BookTypeRepository bookTypeRepository;
    private final Mapper<BookType, BookTypeDto> mapper;

    @Override
    protected BookTypeRepository getEntityRepository() {
        return bookTypeRepository;
    }

    @Override
    protected Mapper<BookType, BookTypeDto> getMapper() {
        return mapper;
    }
}
