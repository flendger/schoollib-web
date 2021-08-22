package org.educationfree.schoollibweb.service.catalog;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookDto;
import org.educationfree.schoollibweb.dto.mapper.Mapper;
import org.educationfree.schoollibweb.model.catalog.Book;
import org.educationfree.schoollibweb.repository.catalog.model.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class BookServiceImpl extends AbstractCatalogService<Book, BookDto> {
    private final BookRepository bookRepository;
    private final Mapper<Book,BookDto> mapper;

    @Override
    protected BookRepository getEntityRepository() {
        return bookRepository;
    }

    @Override
    protected Mapper<Book,BookDto> getMapper( ) {
         return  mapper;
    }

}
