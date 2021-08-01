package org.educationfree.schoollibweb.model.catalog;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends AbstractCatalog {
    @ManyToOne
    @JoinColumn(name = "book_type_id")
    private BookType bookType;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "author")
    private String author;

    @Column(name = "class_from")
    private int classFrom;

    @Column(name = "class_to")
    private int classTo;

    @Column(name = "year")
    private int year;

    @Column(name = "ownership")
    private boolean ownership;

    @Column(name = "price")
    private double price;

    public void setPrice(double price) {
        this.price = (double) Math.round(price*100)/100;
    }
}