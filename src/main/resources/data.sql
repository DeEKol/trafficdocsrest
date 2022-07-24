INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_MODERATOR');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

insert into users ("email", "password", "username") values ('admin@admin.com', '$2a$12$oh.E1w0jdPTKUm6j.F1NKuYr91wFdIjWYZhU.LVrYFmlWCvYMlbI.', 'admin');
-- password="admin" -- 
insert into user_roles (user_id, role_id) values (1, 3);