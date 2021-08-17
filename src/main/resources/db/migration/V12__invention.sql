use school_lib;

DROP TABLE IF EXISTS `invention_items`;
DROP TABLE IF EXISTS `inventions`;

CREATE TABLE `inventions`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT,
    `doc_num`     int        NOT NULL,
    `doc_date`    datetime   NOT NULL,
    `location_id` bigint references locations (id),
    `comment`     varchar(255),
    `is_deleted`  tinyint(1) NOT NULL DEFAULT '0',
    `created_at`  timestamp           default current_timestamp,
    `updated_at`  timestamp           default current_timestamp,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `doc_num` (`doc_num`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE `invention_items`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `doc_id`   bigint NOT NULL references inventions (id),
    `row_num`  int    NOT NULL,
    `book_id`  bigint references books (id),
    `quantity` int    not null default 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

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
