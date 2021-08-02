package org.educationfree.schoollibweb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto extends AbstractCatalogDto {
    private BookTypeDto bookTypeDto;

    private SubjectDto subjectDto;

    private PublisherDto publisherDto;

    private OwnerDto ownerDto;

    private String author;

    private int classFrom;

    private int classTo;

    private int year;

    private boolean ownership;

    private double price;

    public BookDto(Long id, boolean isDeleted, Integer code, String name, BookTypeDto bookTypeDto, SubjectDto subjectDto, PublisherDto publisherDto, OwnerDto ownerDto, String author, int classFrom, int classTo, int year, boolean ownership, double price) {
        super(id, isDeleted, code, name);
        this.bookTypeDto = bookTypeDto;
        this.subjectDto = subjectDto;
        this.publisherDto = publisherDto;
        this.ownerDto = ownerDto;
        this.author = author;
        this.classFrom = classFrom;
        this.classTo = classTo;
        this.year = year;
        this.ownership = ownership;
        this.price = price;
    }
}