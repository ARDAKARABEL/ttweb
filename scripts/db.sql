DROP DATABASE IF EXISTS etsdb;

CREATE DATABASE etsdb CHARACTER SET utf8 COLLATE utf8_general_ci;
USE etsdb;

CREATE TABLE records(
  id INTEGER NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL,
  start DATETIME NOT NULL,
  end DATETIME NOT NULL,
  TIMESTAMP TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE INDEX email_index ON records (email);
CREATE UNIQUE INDEX id_index ON records (id);
CREATE UNIQUE INDEX ese_index ON records (email,start,end);

INSERT INTO records (email, start, end) VALUES ('ardakarabel@gmail.com', '2019-03-10 09:48:00', '2014-02-14 10:48:00');
REPLACE INTO records (email, start, end) VALUES ('ardakarabel@gmail.com', '2019-03-10 09:48:00', '2014-02-14 10:48:00');