CREATE TABLE user_role (
  id int NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uni_username_role (role, user_id),
  KEY fk_username_idx (user_id),
  CONSTRAINT fk_username FOREIGN KEY (user_id) REFERENCES user (id));