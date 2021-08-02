package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.BookTypeDto;
import org.educationfree.schoollibweb.model.catalog.BookType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookTypeMapper implements Mapper<BookType, BookTypeDto>{
    final ModelMapper modelMapper;

    public BookTypeMapper() {
        modelMapper = new ModelMapper();
    }

    @Override
    public BookTypeDto entityToDto(BookType entity) {
        return modelMapper.map(entity,BookTypeDto.class);
    }

    @Override
    public BookType dtoToEntity(BookTypeDto dto) {
        return modelMapper.map(dto,BookType.class);
    }
}
