CREATE SEQUENCE user_seq
     START WITH 1
     INCREMENT BY 1;

CREATE TABLE user_dao (
     id INT NOT NULL DEFAULT (NEXT VALUE FOR user_seq) PRIMARY KEY,
     version INT,
     name VARCHAR(100),
     role VARCHAR(20)
);

