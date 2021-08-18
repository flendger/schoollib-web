package org.educationfree.schoollibweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto extends AbstractCatalogDto {
    private BookTypeDto bookType;

    private SubjectDto subject;

    private PublisherDto publisher;

    private OwnerDto owner;

    private String author;

    private int classFrom;

    private int classTo;

    private int year;

    private boolean ownership;

    private double price;

    public BookDto(Long id,
                   boolean isDeleted,
                   Integer code,
                   String name,
                   BookTypeDto bookTypeDto,
                   SubjectDto subjectDto,
                   PublisherDto publisherDto,
                   OwnerDto ownerDto,
                   String author,
                   int classFrom,
                   int classTo,
                   int year,
                   boolean ownership,
                   double price) {
        super(id, isDeleted, code, name);
        this.bookType = bookTypeDto;
        this.subject = subjectDto;
        this.publisher = publisherDto;
        this.owner = ownerDto;
        this.author = author;
        this.classFrom = classFrom;
        this.classTo = classTo;
        this.year = year;
        this.ownership = ownership;
        this.price = price;
    }
}