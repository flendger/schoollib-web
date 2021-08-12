use school_lib;

DROP TABLE IF EXISTS `inventions`;

CREATE TABLE `inventions`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `doc_num`     int          NOT NULL,
    `doc_date`    datetime     NOT NULL,
    `comment`     varchar(255) NOT NULL,
    `is_deleted`  tinyint(1)   NOT NULL DEFAULT '0',
    `created_at`  timestamp             default current_timestamp,
    `updated_at`  timestamp             default current_timestamp,
    `location_id` bigint references locations (id),
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `doc_num` (`doc_num`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `invention_items`;

CREATE TABLE `invention_items`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `doc_id`   bigint NOT NULL references inventions (id),
    `row`      int    NOT NULL UNIQUE,
    `book_id`  bigint references books (id),
    `quantity` int    not null default 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
