package org.educationfree.schoollibweb.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.BookTypeDto;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookTypeMapper implements Mapper<BookType, BookTypeDto> {
    private final ModelMapper modelMapper;

    @Override
    public BookTypeDto entityToDto(BookType entity) {
        return modelMapper.map(entity, BookTypeDto.class);
    }

    @Override
    public BookType dtoToEntity(BookTypeDto dto) {
        return modelMapper.map(dto, BookType.class);
    }
}
