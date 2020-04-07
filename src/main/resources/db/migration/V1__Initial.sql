-- CATEGORY
CREATE TABLE category (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    picture VARCHAR(2083),
    parent_id INT REFERENCES Category(Id),
    order_number INT
);
CREATE INDEX category_parent_index ON category (parent_id);

-- VIDEO
CREATE TABLE video (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    youtube_id VARCHAR(100) NOT NULL,
    rating DOUBLE,
    description VARCHAR,
    category_id INT REFERENCES Category(Id),
);
CREATE INDEX video_category_index ON video (category_id);
