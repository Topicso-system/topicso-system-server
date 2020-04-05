CREATE TABLE Category (
    Id INT NOT NULL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Picture VARCHAR(2083),
    Parent INT REFERENCES Category(Id),
    OrderNum INT
);