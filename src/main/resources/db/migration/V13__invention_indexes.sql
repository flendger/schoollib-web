alter table invention_items
    add constraint invention_items_books_id_fk
        foreign key (book_id) references books (id)
            on delete set null;

alter table inventions
    add constraint inventions_locations_id_fk
        foreign key (location_id) references locations (id)
            on delete set null;

alter table invention_items
    add constraint invention_items_inventions_id_fk
        foreign key (doc_id) references inventions (id)
            on delete cascade;

