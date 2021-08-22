package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.*;
import org.educationfree.schoollibweb.model.catalog.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookMapperTest {
    private  ModelMapper modelMapper;

@BeforeEach
void init(){
    this.modelMapper = new ModelMapper();
    modelMapper.addMappings(new PropertyMap<Book, BookDto>() {
        @Override
        protected void configure() {
            when(ctx -> ctx.getSource() == null ).skip(source.getBookType(),destination.getBookType());
            when(ctx -> ctx.getSource() == null ).skip(source.getOwner(),destination.getOwner());
            when(ctx -> ctx.getSource() == null ).skip(source.getPublisher(),destination.getPublisher());
            when(ctx -> ctx.getSource() == null ).skip(source.getSubject(),destination.getSubject());
        }
    });
    modelMapper.addMappings(new PropertyMap<BookDto, Book>() {
        @Override
        protected void configure() {
            when(ctx -> ctx.getSource() == null ).skip(source.getBookType(),destination.getBookType());
            when(ctx -> ctx.getSource() == null ).skip(source.getOwner(),destination.getOwner());
            when(ctx -> ctx.getSource() == null ).skip(source.getPublisher(),destination.getPublisher());
            when(ctx -> ctx.getSource() == null ).skip(source.getSubject(),destination.getSubject());
        }
    });
}

    @Test
    void entityToDto() {
        BookMapper bookMapper = new BookMapper(modelMapper);
        Book book = new Book(1L, false, 1, "SomeBook",
                new BookType(1L, false, 1, "SomeCategory"),
                new Subject(1L, false, 1, "Math"),
                new Publisher(1L, false, 1, "Pascal"),
                new Owner(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21
        );
        BookDto actual = bookMapper.entityToDto(book);
        assertNotNull(actual);
        BookDto expected = new BookDto(1L, false, 1, "SomeBook",
                new BookTypeDto(1L, false, 1, "SomeCategory"),
                new SubjectDto(1L, false, 1, "Math"),
                new PublisherDto(1L, false, 1, "Pascal"),
                new OwnerDto(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21);
        assertEquals(expected, actual);
    }

    @Test
    void entityToDtoWithNullProperty() {

        BookMapper bookMapper = new BookMapper(modelMapper);
        Book book = new Book(1L, false, 1, "SomeBook",
                null,
                new Subject(1L, false, 1, "Math"),
                new Publisher(1L, false, 1, "Pascal"),
                new Owner(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21
        );
        BookDto actual = bookMapper.entityToDto(book);
        assertNotNull(actual);
        BookDto expected = new BookDto(1L, false, 1, "SomeBook",
                null,
                new SubjectDto(1L, false, 1, "Math"),
                new PublisherDto(1L, false, 1, "Pascal"),
                new OwnerDto(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21);
        assertEquals(expected, actual);
    }

    @Test
    void dtoToEntity() {
        BookMapper bookMapper = new BookMapper(modelMapper);
        BookDto bookDto = new BookDto(1L, false, 1, "SomeBook",
                new BookTypeDto(1L, false, 1, "SomeCategory"),
                new SubjectDto(1L, false, 1, "Math"),
                new PublisherDto(1L, false, 1, "Pascal"),
                new OwnerDto(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21);

        Book actual = bookMapper.dtoToEntity(bookDto);
        assertNotNull(actual);
        Book expected = new Book(1L, false, 1, "SomeBook",new BookType(1L, false, 1, "SomeCategory"),
                new Subject(1L, false, 1, "Math"),
                new Publisher(1L, false, 1, "Pascal"),
                new Owner(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21
        );
        assertEquals(expected, actual);
    }

    @Test
    void dtoToEntityWithNullProperty() {
        BookMapper bookMapper = new BookMapper(new ModelMapper());
        BookDto bookDto = new BookDto(1L, false, 1, "SomeBook",
                null,
                new SubjectDto(1L, false, 1, "Math"),
                new PublisherDto(1L, false, 1, "Pascal"),
                new OwnerDto(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21);

        Book actual = bookMapper.dtoToEntity(bookDto);
        assertNotNull(actual);
        Book expected = new Book(1L, false, 1, "SomeBook",
                null,
                new Subject(1L, false, 1, "Math"),
                new Publisher(1L, false, 1, "Pascal"),
                new Owner(1L, false, 1, "Somebody"),
                "Pushkin", 1, 2, 2020, false, 21.21
        );
        assertEquals(expected, actual);
    }
}