CREATE TABLE category (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    picture VARCHAR(2083),
    parent_id INT REFERENCES Category(Id),
    order_number INT
);