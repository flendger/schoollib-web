package org.educationfree.schoollibweb.dto;

import org.educationfree.schoollibweb.model.catalog.AbstractCatalog;

public class BookDto extends AbstractCatalog {

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

    public void setPrice(double price) {
        this.price = (double) Math.round(price * 100) / 100;
    }
}