CREATE TABLE user_dao (
     id SERIAL PRIMARY KEY,
     version INT,
     name VARCHAR(100),
     role VARCHAR(20)
);

