CREATE TABLE auth (
  id       int(11) PRIMARY KEY AUTO_INCREMENT ,
  username VARCHAR(75) NOT NULL,
  email   VARCHAR(255) NOT NULL,
  password   VARCHAR(255) NOT NULL
);