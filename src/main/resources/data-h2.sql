-- for category
INSERT INTO category (id, category_name) VALUES (1, 'Wedding');
INSERT INTO category (id, category_name) VALUES (2, 'Corporate');
INSERT INTO category (id, category_name) VALUES (3, 'Birthday');

-- for subcategory
INSERT INTO sub_category (id, sub_category_name, category_id) VALUES (1, 'Sub Wedding 1', 1);
INSERT INTO sub_category (id, sub_category_name, category_id) VALUES (2, 'Sub Wedding 2', 1);
INSERT INTO sub_category (id, sub_category_name, category_id) VALUES (3, 'Sub Corporate 1', 2);
INSERT INTO sub_category (id, sub_category_name, category_id) VALUES (4, 'Sub Birthday 1', 3);
INSERT INTO sub_category (id, sub_category_name, category_id) VALUES (5, 'Sub Birthday 2', 3);
INSERT INTO sub_category (id, sub_category_name, category_id) VALUES (6, 'Sub Birthday 3', 3);

-- for role and user
INSERT INTO role (id, role_name) VALUES (1, 'CUSTOMER');
INSERT INTO role (id, role_name) VALUES (2, 'PHOTOGRAPHER');
INSERT INTO user_entity (id, username, password, email) VALUES (1, 'lebron', 'lakers', 'lebron@gmail.com');
INSERT INTO user_entity (id, username, password, email) VALUES (2, 'kobe', 'lakers', 'kobe@gmail.com');
INSERT INTO user_entity (id, username, password, email) VALUES (3, 'shaq', 'lakers', 'shaq@gmail.com');
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);

-- for offering
INSERT INTO offering (id, description, user_id, category_id, sub_category_id) VALUES (1, 'Extravagant Wedding in Paris', 3, 1, 2);

-- for media
INSERT INTO media (filepath, offering_id) VALUES ('filepath1', 1);
INSERT INTO media (filepath, offering_id) VALUES ('filepath2', 1);

-- for booking
INSERT INTO booking (description, customer_user_id, photographer_user_id, offering_id) VALUES ('booking1', 1, 3, 1);



