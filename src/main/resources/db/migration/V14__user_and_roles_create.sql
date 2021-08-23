DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id                    BIGINT NOT NULL AUTO_INCREMENT,
  username              VARCHAR(50) NOT NULL UNIQUE,
  password              CHAR(80) NOT NULL,
  first_name            VARCHAR(150),
  last_name             VARCHAR(150),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id                    BIGINT NOT NULL AUTO_INCREMENT,
  name                  VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  user_id               BIGINT NOT NULL,
  role_id               BIGINT NOT NULL,

  PRIMARY KEY (user_id, role_id),

--  KEY FK_ROLE_idx (role_id),

  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES users (id)
  ON DELETE CASCADE ON UPDATE NO ACTION,

  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES roles (id)
  ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = utf8;