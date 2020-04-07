-- CATEGORY
CREATE TABLE category (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    picture VARCHAR(2083) NOT NULL,
    parent_id INT REFERENCES Category(Id),
    order_number INT
);
CREATE INDEX category_parent_index ON category (parent_id);

-- VIDEO
CREATE TABLE video (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR NOT NULL,
    youtube_id VARCHAR(100) NOT NULL,
    rating DOUBLE,
    description TEXT,
    category_id INT REFERENCES Category(Id),
);
CREATE INDEX video_category_index ON video (category_id);
