INSERT INTO users (password, username, enabled)
VALUES ('$2a$10$iKeasQSKNW67KFOyJqKhL.HJfZrvFpRZnf6YxAlFoqcXkdBdeezbS', 'Admin', true);

INSERT into authorities (authority, username)
VALUES ('ROLE_ADMIN', 'Admin')