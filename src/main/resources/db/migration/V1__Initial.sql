--DROP TABLE video;
--DROP TABLE category;
--DROP TABLE flyway_schema_history;

-- CATEGORY
CREATE TABLE category (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    picture VARCHAR(2083) NOT NULL,
    parent_id INT REFERENCES Category(Id),
    order_number INT
);
CREATE INDEX category_parent_index ON category (parent_id);

-- VIDEO
CREATE TABLE video (
    id SERIAL NOT NULL PRIMARY KEY,
    title VARCHAR NOT NULL,
    youtube_id VARCHAR(100) NOT NULL,
    rating NUMERIC(2),
    description TEXT,
    difficulty_level VARCHAR(50) NOT NULL,
    category_id INT REFERENCES Category(Id)
);
CREATE INDEX video_category_index ON video (category_id);
