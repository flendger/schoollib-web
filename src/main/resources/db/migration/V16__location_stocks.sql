use school_lib;

DROP TABLE IF EXISTS `inventions_location_stocks`;
DROP TABLE IF EXISTS `location_stocks`;

CREATE TABLE `location_stocks`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT,
    `entry_date`    datetime   NOT NULL,
    `book_id` bigint references books (id),
    `location_id` bigint references locations (id),
    `quantity` int not null default 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

alter table location_stocks
    add constraint location_books_id_fk
        foreign key (book_id) references books (id)
            on delete set null;

alter table location_stocks
    add constraint location_stocks_id_fk
        foreign key (location_id) references locations (id)
            on delete set null;

CREATE TABLE `inventions_location_stocks`
(
    `doc_id` bigint references inventions (id),
    `entry_id` bigint references location_stocks (id),
    PRIMARY KEY (`doc_id`, `entry_id`),
    CONSTRAINT FK_DOC_ID FOREIGN KEY (`doc_id`) REFERENCES inventions(id)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT FK_ENTRY_ID FOREIGN KEY (`entry_id`) REFERENCES location_stocks(id)
        ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

create index inventions_location_stocks_doc_id_index
    on inventions_location_stocks (doc_id);

