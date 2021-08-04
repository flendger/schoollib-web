-- books
alter table books
    add constraint books_book_types_id_fk
        foreign key (book_type_id) references book_types (id);

alter table books
    add constraint books_owners_id_fk
        foreign key (owner_id) references owners (id);

alter table books
    add constraint books_publishers_id_fk
        foreign key (publisher_id) references publishers (id);

alter table books
    add constraint books_subjects_id_fk
        foreign key (subject_id) references subjects (id);

-- locations
alter table locations
    add constraint locations_location_types_id_fk
        foreign key (location_type_id) references location_types (id);

alter table locations
    add constraint locations_people_id_fk
        foreign key (person_id) references people (id);

