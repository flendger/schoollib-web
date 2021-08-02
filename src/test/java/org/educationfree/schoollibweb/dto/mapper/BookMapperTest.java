package org.educationfree.schoollibweb.dto.mapper;

import org.educationfree.schoollibweb.dto.*;
import org.educationfree.schoollibweb.model.catalog.*;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void entityToDto() {
        BookMapper bookMapper = new BookMapper(new ModelMapper());
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
    void dtoToEntity() {
        BookMapper bookMapper = new BookMapper(new ModelMapper());
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
}