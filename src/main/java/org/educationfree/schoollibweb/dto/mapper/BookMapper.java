package org.educationfree.schoollibweb.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.*;
import org.educationfree.schoollibweb.model.catalog.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper implements Mapper<Book, BookDto> {
    private final ModelMapper modelMapper;

    @Override
    public BookDto entityToDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public Book dtoToEntity(BookDto bookDto) {
        return modelMapper.map(bookDto,Book.class);
    }
}
