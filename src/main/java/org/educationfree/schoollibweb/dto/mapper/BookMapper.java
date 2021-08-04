package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.*;
import org.educationfree.schoollibweb.model.catalog.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<Book, BookDto> {
    final   ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto entityToDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public Book dtoToEntity(BookDto bookDto) {
        return modelMapper.map(bookDto,Book.class);
    }
}
