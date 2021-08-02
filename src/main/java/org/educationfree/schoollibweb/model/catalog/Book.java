package org.educationfree.schoollibweb.model.catalog;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
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

    public Book(Long id, boolean isDeleted, Integer code, String name, BookType bookType, Subject subject, Publisher publisher, Owner owner, String author, int classFrom, int classTo, int year, boolean ownership, double price) {
        super(id, isDeleted, code, name);
        this.bookType = bookType;
        this.subject = subject;
        this.publisher = publisher;
        this.owner = owner;
        this.author = author;
        this.classFrom = classFrom;
        this.classTo = classTo;
        this.year = year;
        this.ownership = ownership;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = (double) Math.round(price*100)/100;
    }
}