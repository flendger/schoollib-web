use school_lib;

DROP TABLE IF EXISTS `receipt_from_publisher_items`;
DROP TABLE IF EXISTS receipts_from_publisher;

CREATE TABLE receipts_from_publisher
(
    `id`           bigint     NOT NULL AUTO_INCREMENT,
    `doc_num`      int        NOT NULL,
    `doc_date`     datetime   NOT NULL,
    `publisher_id` bigint references publishers (id),
    `location_id`  bigint references locations (id),
    `comment`      varchar(255),
    `is_deleted`   tinyint(1) NOT NULL DEFAULT '0',
    `created_at`   timestamp           default current_timestamp,
    `updated_at`   timestamp           default current_timestamp,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `doc_num` (`doc_num`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE `receipt_from_publisher_items`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `doc_id`   bigint NOT NULL references receipts_from_publisher (id),
    `row_num`  int    NOT NULL,
    `book_id`  bigint references books (id),
    `quantity` int    not null default 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

alter table receipt_from_publisher_items
    add constraint receipt_from_publisher_items_books_id_fk
        foreign key (book_id) references books (id)
            on delete set null;

alter table receipts_from_publisher
    add constraint receipts_from_publisher_locations_id_fk
        foreign key (location_id) references locations (id)
            on delete set null;

alter table receipt_from_publisher_items
    add constraint receipt_from_publisher_items_doc_id_fk
        foreign key (doc_id) references receipts_from_publisher (id)
            on delete cascade;
