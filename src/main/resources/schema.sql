CREATE TABLE IF NOT EXISTS users(
    id varchar(255) NOT NULL,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP ,
    deleted_at TIMESTAMP ,
    PRIMARY KEY(id)
);