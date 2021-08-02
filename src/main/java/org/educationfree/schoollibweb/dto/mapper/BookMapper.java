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
    public BookDto EntityToDto(Book book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        bookDto.setBookTypeDto(modelMapper.map(book.getBookType(), BookTypeDto.class));
        bookDto.setOwnerDto(modelMapper.map(book.getOwner(), OwnerDto.class));
        bookDto.setPublisherDto(modelMapper.map(book.getPublisher(), PublisherDto.class));
        bookDto.setSubjectDto(modelMapper.map(book.getSubject(), SubjectDto.class));
        return bookDto;
    }

    @Override
    public Book DtoToEntity(BookDto bookDto) {
        Book book =  modelMapper.map(bookDto,Book.class);
        book.setBookType(modelMapper.map(bookDto.getBookTypeDto(), BookType.class));
        book.setOwner(modelMapper.map(bookDto.getOwnerDto(), Owner.class));
        book.setPublisher(modelMapper.map(bookDto.getPublisherDto(), Publisher.class));
        book.setSubject(modelMapper.map(bookDto.getSubjectDto(), Subject.class));
        return book;
    }
}
