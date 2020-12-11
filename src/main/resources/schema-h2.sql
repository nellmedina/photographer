-- for category
CREATE TABLE category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  category_name VARCHAR(100)
);

-- for sub_category
CREATE TABLE sub_category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  sub_category_name VARCHAR(100),
  category_id INT NOT NULL,
  CONSTRAINT sub_category_category_fk FOREIGN KEY (category_id) REFERENCES category(id)
);

-- for user_entity
CREATE TABLE user_entity (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(500) NOT NULL,
  email VARCHAR(100)
);

-- for user_entity
CREATE TABLE role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(50)
);

-- for user_role many to many mapping
CREATE TABLE user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT user_role_user_fk FOREIGN KEY (user_id) REFERENCES user_entity(id),
  CONSTRAINT user_role_role_fk FOREIGN KEY (role_id) REFERENCES role(id)
);

-- for offering
CREATE TABLE offering (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(250),
  user_id INT NOT NULL,
  category_id INT NOT NULL,
  sub_category_id INT NOT NULL,
  CONSTRAINT offering_user_entity_fk FOREIGN KEY (user_id) REFERENCES user_entity(id),
  CONSTRAINT offering_category_fk FOREIGN KEY (category_id) REFERENCES category(id),
  CONSTRAINT offering_sub_category_fk FOREIGN KEY (sub_category_id) REFERENCES sub_category(id)
);


-- for booking
-- TBA....




