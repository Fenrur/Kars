CREATE TABLE authors
(
    id         SERIAL PRIMARY KEY,
    last_name  TEXT NOT NULL ,
    first_name TEXT NOT NULL 
);

CREATE TABLE books
(
    id             SERIAL PRIMARY KEY,
    title          TEXT NOT NULL ,
    description    TEXT NOT NULL ,
    published_year INT NOT NULL ,
    author_id      INT NOT NULL REFERENCES authors (id)
);